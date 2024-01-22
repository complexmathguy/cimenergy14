package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.production.aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

/**
 * Aggregate handler for GeneratingUnit as outlined for the CQRS pattern, all write responsibilities
 * related to GeneratingUnit are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class GeneratingUnitAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public GeneratingUnitAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public GeneratingUnitAggregate(CreateGeneratingUnitCommand command) throws Exception {
    LOGGER.info("Handling command CreateGeneratingUnitCommand");
    CreateGeneratingUnitEvent event =
        new CreateGeneratingUnitEvent(command.getGeneratingUnitId(), command.getGenControlSource());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateGeneratingUnitCommand command) throws Exception {
    LOGGER.info("handling command UpdateGeneratingUnitCommand");
    UpdateGeneratingUnitEvent event =
        new UpdateGeneratingUnitEvent(
            command.getGeneratingUnitId(),
            command.getGenControlSource(),
            command.getGovernorSCD(),
            command.getInitialP(),
            command.getLongPF(),
            command.getMaximumAllowableSpinningReserve(),
            command.getMaxOperatingP(),
            command.getMinOperatingP(),
            command.getNominalP(),
            command.getRatedGrossMaxP(),
            command.getRatedGrossMinP(),
            command.getRatedNetMaxP(),
            command.getShortPF(),
            command.getStartupCost(),
            command.getTotalEfficiency(),
            command.getVariableCost());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteGeneratingUnitCommand command) throws Exception {
    LOGGER.info("Handling command DeleteGeneratingUnitCommand");
    apply(new DeleteGeneratingUnitEvent(command.getGeneratingUnitId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignGovernorSCDToGeneratingUnitCommand command) throws Exception {
    LOGGER.info("Handling command AssignGovernorSCDToGeneratingUnitCommand");

    if (governorSCD != null && governorSCD.getPerCentId() == command.getAssignment().getPerCentId())
      throw new ProcessingException(
          "GovernorSCD already assigned with id " + command.getAssignment().getPerCentId());

    apply(
        new AssignGovernorSCDToGeneratingUnitEvent(
            command.getGeneratingUnitId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignGovernorSCDFromGeneratingUnitCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignGovernorSCDFromGeneratingUnitCommand");

    if (governorSCD == null)
      throw new ProcessingException("GovernorSCD already has nothing assigned.");

    apply(new UnAssignGovernorSCDFromGeneratingUnitEvent(command.getGeneratingUnitId()));
  }

  @CommandHandler
  public void handle(AssignInitialPToGeneratingUnitCommand command) throws Exception {
    LOGGER.info("Handling command AssignInitialPToGeneratingUnitCommand");

    if (initialP != null
        && initialP.getActivePowerId() == command.getAssignment().getActivePowerId())
      throw new ProcessingException(
          "InitialP already assigned with id " + command.getAssignment().getActivePowerId());

    apply(
        new AssignInitialPToGeneratingUnitEvent(
            command.getGeneratingUnitId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignInitialPFromGeneratingUnitCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignInitialPFromGeneratingUnitCommand");

    if (initialP == null) throw new ProcessingException("InitialP already has nothing assigned.");

    apply(new UnAssignInitialPFromGeneratingUnitEvent(command.getGeneratingUnitId()));
  }

  @CommandHandler
  public void handle(AssignLongPFToGeneratingUnitCommand command) throws Exception {
    LOGGER.info("Handling command AssignLongPFToGeneratingUnitCommand");

    if (longPF != null && longPF.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "LongPF already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignLongPFToGeneratingUnitEvent(
            command.getGeneratingUnitId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignLongPFFromGeneratingUnitCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignLongPFFromGeneratingUnitCommand");

    if (longPF == null) throw new ProcessingException("LongPF already has nothing assigned.");

    apply(new UnAssignLongPFFromGeneratingUnitEvent(command.getGeneratingUnitId()));
  }

  @CommandHandler
  public void handle(AssignMaximumAllowableSpinningReserveToGeneratingUnitCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignMaximumAllowableSpinningReserveToGeneratingUnitCommand");

    if (maximumAllowableSpinningReserve != null
        && maximumAllowableSpinningReserve.getActivePowerId()
            == command.getAssignment().getActivePowerId())
      throw new ProcessingException(
          "MaximumAllowableSpinningReserve already assigned with id "
              + command.getAssignment().getActivePowerId());

    apply(
        new AssignMaximumAllowableSpinningReserveToGeneratingUnitEvent(
            command.getGeneratingUnitId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMaximumAllowableSpinningReserveFromGeneratingUnitCommand command)
      throws Exception {
    LOGGER.info(
        "Handlign command UnAssignMaximumAllowableSpinningReserveFromGeneratingUnitCommand");

    if (maximumAllowableSpinningReserve == null)
      throw new ProcessingException(
          "MaximumAllowableSpinningReserve already has nothing assigned.");

    apply(
        new UnAssignMaximumAllowableSpinningReserveFromGeneratingUnitEvent(
            command.getGeneratingUnitId()));
  }

  @CommandHandler
  public void handle(AssignMaxOperatingPToGeneratingUnitCommand command) throws Exception {
    LOGGER.info("Handling command AssignMaxOperatingPToGeneratingUnitCommand");

    if (maxOperatingP != null
        && maxOperatingP.getActivePowerId() == command.getAssignment().getActivePowerId())
      throw new ProcessingException(
          "MaxOperatingP already assigned with id " + command.getAssignment().getActivePowerId());

    apply(
        new AssignMaxOperatingPToGeneratingUnitEvent(
            command.getGeneratingUnitId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMaxOperatingPFromGeneratingUnitCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignMaxOperatingPFromGeneratingUnitCommand");

    if (maxOperatingP == null)
      throw new ProcessingException("MaxOperatingP already has nothing assigned.");

    apply(new UnAssignMaxOperatingPFromGeneratingUnitEvent(command.getGeneratingUnitId()));
  }

  @CommandHandler
  public void handle(AssignMinOperatingPToGeneratingUnitCommand command) throws Exception {
    LOGGER.info("Handling command AssignMinOperatingPToGeneratingUnitCommand");

    if (minOperatingP != null
        && minOperatingP.getActivePowerId() == command.getAssignment().getActivePowerId())
      throw new ProcessingException(
          "MinOperatingP already assigned with id " + command.getAssignment().getActivePowerId());

    apply(
        new AssignMinOperatingPToGeneratingUnitEvent(
            command.getGeneratingUnitId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMinOperatingPFromGeneratingUnitCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignMinOperatingPFromGeneratingUnitCommand");

    if (minOperatingP == null)
      throw new ProcessingException("MinOperatingP already has nothing assigned.");

    apply(new UnAssignMinOperatingPFromGeneratingUnitEvent(command.getGeneratingUnitId()));
  }

  @CommandHandler
  public void handle(AssignNominalPToGeneratingUnitCommand command) throws Exception {
    LOGGER.info("Handling command AssignNominalPToGeneratingUnitCommand");

    if (nominalP != null
        && nominalP.getActivePowerId() == command.getAssignment().getActivePowerId())
      throw new ProcessingException(
          "NominalP already assigned with id " + command.getAssignment().getActivePowerId());

    apply(
        new AssignNominalPToGeneratingUnitEvent(
            command.getGeneratingUnitId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignNominalPFromGeneratingUnitCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignNominalPFromGeneratingUnitCommand");

    if (nominalP == null) throw new ProcessingException("NominalP already has nothing assigned.");

    apply(new UnAssignNominalPFromGeneratingUnitEvent(command.getGeneratingUnitId()));
  }

  @CommandHandler
  public void handle(AssignRatedGrossMaxPToGeneratingUnitCommand command) throws Exception {
    LOGGER.info("Handling command AssignRatedGrossMaxPToGeneratingUnitCommand");

    if (ratedGrossMaxP != null
        && ratedGrossMaxP.getActivePowerId() == command.getAssignment().getActivePowerId())
      throw new ProcessingException(
          "RatedGrossMaxP already assigned with id " + command.getAssignment().getActivePowerId());

    apply(
        new AssignRatedGrossMaxPToGeneratingUnitEvent(
            command.getGeneratingUnitId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRatedGrossMaxPFromGeneratingUnitCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignRatedGrossMaxPFromGeneratingUnitCommand");

    if (ratedGrossMaxP == null)
      throw new ProcessingException("RatedGrossMaxP already has nothing assigned.");

    apply(new UnAssignRatedGrossMaxPFromGeneratingUnitEvent(command.getGeneratingUnitId()));
  }

  @CommandHandler
  public void handle(AssignRatedGrossMinPToGeneratingUnitCommand command) throws Exception {
    LOGGER.info("Handling command AssignRatedGrossMinPToGeneratingUnitCommand");

    if (ratedGrossMinP != null
        && ratedGrossMinP.getActivePowerId() == command.getAssignment().getActivePowerId())
      throw new ProcessingException(
          "RatedGrossMinP already assigned with id " + command.getAssignment().getActivePowerId());

    apply(
        new AssignRatedGrossMinPToGeneratingUnitEvent(
            command.getGeneratingUnitId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRatedGrossMinPFromGeneratingUnitCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignRatedGrossMinPFromGeneratingUnitCommand");

    if (ratedGrossMinP == null)
      throw new ProcessingException("RatedGrossMinP already has nothing assigned.");

    apply(new UnAssignRatedGrossMinPFromGeneratingUnitEvent(command.getGeneratingUnitId()));
  }

  @CommandHandler
  public void handle(AssignRatedNetMaxPToGeneratingUnitCommand command) throws Exception {
    LOGGER.info("Handling command AssignRatedNetMaxPToGeneratingUnitCommand");

    if (ratedNetMaxP != null
        && ratedNetMaxP.getActivePowerId() == command.getAssignment().getActivePowerId())
      throw new ProcessingException(
          "RatedNetMaxP already assigned with id " + command.getAssignment().getActivePowerId());

    apply(
        new AssignRatedNetMaxPToGeneratingUnitEvent(
            command.getGeneratingUnitId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRatedNetMaxPFromGeneratingUnitCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignRatedNetMaxPFromGeneratingUnitCommand");

    if (ratedNetMaxP == null)
      throw new ProcessingException("RatedNetMaxP already has nothing assigned.");

    apply(new UnAssignRatedNetMaxPFromGeneratingUnitEvent(command.getGeneratingUnitId()));
  }

  @CommandHandler
  public void handle(AssignShortPFToGeneratingUnitCommand command) throws Exception {
    LOGGER.info("Handling command AssignShortPFToGeneratingUnitCommand");

    if (shortPF != null
        && shortPF.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "ShortPF already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignShortPFToGeneratingUnitEvent(
            command.getGeneratingUnitId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignShortPFFromGeneratingUnitCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignShortPFFromGeneratingUnitCommand");

    if (shortPF == null) throw new ProcessingException("ShortPF already has nothing assigned.");

    apply(new UnAssignShortPFFromGeneratingUnitEvent(command.getGeneratingUnitId()));
  }

  @CommandHandler
  public void handle(AssignStartupCostToGeneratingUnitCommand command) throws Exception {
    LOGGER.info("Handling command AssignStartupCostToGeneratingUnitCommand");

    if (startupCost != null && startupCost.getMoneyId() == command.getAssignment().getMoneyId())
      throw new ProcessingException(
          "StartupCost already assigned with id " + command.getAssignment().getMoneyId());

    apply(
        new AssignStartupCostToGeneratingUnitEvent(
            command.getGeneratingUnitId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignStartupCostFromGeneratingUnitCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignStartupCostFromGeneratingUnitCommand");

    if (startupCost == null)
      throw new ProcessingException("StartupCost already has nothing assigned.");

    apply(new UnAssignStartupCostFromGeneratingUnitEvent(command.getGeneratingUnitId()));
  }

  @CommandHandler
  public void handle(AssignTotalEfficiencyToGeneratingUnitCommand command) throws Exception {
    LOGGER.info("Handling command AssignTotalEfficiencyToGeneratingUnitCommand");

    if (totalEfficiency != null
        && totalEfficiency.getPerCentId() == command.getAssignment().getPerCentId())
      throw new ProcessingException(
          "TotalEfficiency already assigned with id " + command.getAssignment().getPerCentId());

    apply(
        new AssignTotalEfficiencyToGeneratingUnitEvent(
            command.getGeneratingUnitId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTotalEfficiencyFromGeneratingUnitCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTotalEfficiencyFromGeneratingUnitCommand");

    if (totalEfficiency == null)
      throw new ProcessingException("TotalEfficiency already has nothing assigned.");

    apply(new UnAssignTotalEfficiencyFromGeneratingUnitEvent(command.getGeneratingUnitId()));
  }

  @CommandHandler
  public void handle(AssignVariableCostToGeneratingUnitCommand command) throws Exception {
    LOGGER.info("Handling command AssignVariableCostToGeneratingUnitCommand");

    if (variableCost != null && variableCost.getMoneyId() == command.getAssignment().getMoneyId())
      throw new ProcessingException(
          "VariableCost already assigned with id " + command.getAssignment().getMoneyId());

    apply(
        new AssignVariableCostToGeneratingUnitEvent(
            command.getGeneratingUnitId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVariableCostFromGeneratingUnitCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVariableCostFromGeneratingUnitCommand");

    if (variableCost == null)
      throw new ProcessingException("VariableCost already has nothing assigned.");

    apply(new UnAssignVariableCostFromGeneratingUnitEvent(command.getGeneratingUnitId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateGeneratingUnitEvent event) {
    LOGGER.info("Event sourcing CreateGeneratingUnitEvent");
    this.generatingUnitId = event.getGeneratingUnitId();
    this.genControlSource = event.getGenControlSource();
  }

  @EventSourcingHandler
  void on(UpdateGeneratingUnitEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.genControlSource = event.getGenControlSource();
    this.governorSCD = event.getGovernorSCD();
    this.initialP = event.getInitialP();
    this.longPF = event.getLongPF();
    this.maximumAllowableSpinningReserve = event.getMaximumAllowableSpinningReserve();
    this.maxOperatingP = event.getMaxOperatingP();
    this.minOperatingP = event.getMinOperatingP();
    this.nominalP = event.getNominalP();
    this.ratedGrossMaxP = event.getRatedGrossMaxP();
    this.ratedGrossMinP = event.getRatedGrossMinP();
    this.ratedNetMaxP = event.getRatedNetMaxP();
    this.shortPF = event.getShortPF();
    this.startupCost = event.getStartupCost();
    this.totalEfficiency = event.getTotalEfficiency();
    this.variableCost = event.getVariableCost();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignGovernorSCDToGeneratingUnitEvent event) {
    LOGGER.info("Event sourcing AssignGovernorSCDToGeneratingUnitEvent");
    this.governorSCD = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignGovernorSCDFromGeneratingUnitEvent event) {
    LOGGER.info("Event sourcing UnAssignGovernorSCDFromGeneratingUnitEvent");
    this.governorSCD = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignInitialPToGeneratingUnitEvent event) {
    LOGGER.info("Event sourcing AssignInitialPToGeneratingUnitEvent");
    this.initialP = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignInitialPFromGeneratingUnitEvent event) {
    LOGGER.info("Event sourcing UnAssignInitialPFromGeneratingUnitEvent");
    this.initialP = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignLongPFToGeneratingUnitEvent event) {
    LOGGER.info("Event sourcing AssignLongPFToGeneratingUnitEvent");
    this.longPF = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignLongPFFromGeneratingUnitEvent event) {
    LOGGER.info("Event sourcing UnAssignLongPFFromGeneratingUnitEvent");
    this.longPF = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMaximumAllowableSpinningReserveToGeneratingUnitEvent event) {
    LOGGER.info("Event sourcing AssignMaximumAllowableSpinningReserveToGeneratingUnitEvent");
    this.maximumAllowableSpinningReserve = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMaximumAllowableSpinningReserveFromGeneratingUnitEvent event) {
    LOGGER.info("Event sourcing UnAssignMaximumAllowableSpinningReserveFromGeneratingUnitEvent");
    this.maximumAllowableSpinningReserve = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMaxOperatingPToGeneratingUnitEvent event) {
    LOGGER.info("Event sourcing AssignMaxOperatingPToGeneratingUnitEvent");
    this.maxOperatingP = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMaxOperatingPFromGeneratingUnitEvent event) {
    LOGGER.info("Event sourcing UnAssignMaxOperatingPFromGeneratingUnitEvent");
    this.maxOperatingP = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMinOperatingPToGeneratingUnitEvent event) {
    LOGGER.info("Event sourcing AssignMinOperatingPToGeneratingUnitEvent");
    this.minOperatingP = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMinOperatingPFromGeneratingUnitEvent event) {
    LOGGER.info("Event sourcing UnAssignMinOperatingPFromGeneratingUnitEvent");
    this.minOperatingP = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignNominalPToGeneratingUnitEvent event) {
    LOGGER.info("Event sourcing AssignNominalPToGeneratingUnitEvent");
    this.nominalP = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignNominalPFromGeneratingUnitEvent event) {
    LOGGER.info("Event sourcing UnAssignNominalPFromGeneratingUnitEvent");
    this.nominalP = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRatedGrossMaxPToGeneratingUnitEvent event) {
    LOGGER.info("Event sourcing AssignRatedGrossMaxPToGeneratingUnitEvent");
    this.ratedGrossMaxP = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRatedGrossMaxPFromGeneratingUnitEvent event) {
    LOGGER.info("Event sourcing UnAssignRatedGrossMaxPFromGeneratingUnitEvent");
    this.ratedGrossMaxP = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRatedGrossMinPToGeneratingUnitEvent event) {
    LOGGER.info("Event sourcing AssignRatedGrossMinPToGeneratingUnitEvent");
    this.ratedGrossMinP = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRatedGrossMinPFromGeneratingUnitEvent event) {
    LOGGER.info("Event sourcing UnAssignRatedGrossMinPFromGeneratingUnitEvent");
    this.ratedGrossMinP = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRatedNetMaxPToGeneratingUnitEvent event) {
    LOGGER.info("Event sourcing AssignRatedNetMaxPToGeneratingUnitEvent");
    this.ratedNetMaxP = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRatedNetMaxPFromGeneratingUnitEvent event) {
    LOGGER.info("Event sourcing UnAssignRatedNetMaxPFromGeneratingUnitEvent");
    this.ratedNetMaxP = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignShortPFToGeneratingUnitEvent event) {
    LOGGER.info("Event sourcing AssignShortPFToGeneratingUnitEvent");
    this.shortPF = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignShortPFFromGeneratingUnitEvent event) {
    LOGGER.info("Event sourcing UnAssignShortPFFromGeneratingUnitEvent");
    this.shortPF = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignStartupCostToGeneratingUnitEvent event) {
    LOGGER.info("Event sourcing AssignStartupCostToGeneratingUnitEvent");
    this.startupCost = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignStartupCostFromGeneratingUnitEvent event) {
    LOGGER.info("Event sourcing UnAssignStartupCostFromGeneratingUnitEvent");
    this.startupCost = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTotalEfficiencyToGeneratingUnitEvent event) {
    LOGGER.info("Event sourcing AssignTotalEfficiencyToGeneratingUnitEvent");
    this.totalEfficiency = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTotalEfficiencyFromGeneratingUnitEvent event) {
    LOGGER.info("Event sourcing UnAssignTotalEfficiencyFromGeneratingUnitEvent");
    this.totalEfficiency = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVariableCostToGeneratingUnitEvent event) {
    LOGGER.info("Event sourcing AssignVariableCostToGeneratingUnitEvent");
    this.variableCost = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVariableCostFromGeneratingUnitEvent event) {
    LOGGER.info("Event sourcing UnAssignVariableCostFromGeneratingUnitEvent");
    this.variableCost = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID generatingUnitId;

  private GeneratorControlSource genControlSource;
  private PerCent governorSCD = null;
  private ActivePower initialP = null;
  private Simple_Float longPF = null;
  private ActivePower maximumAllowableSpinningReserve = null;
  private ActivePower maxOperatingP = null;
  private ActivePower minOperatingP = null;
  private ActivePower nominalP = null;
  private ActivePower ratedGrossMaxP = null;
  private ActivePower ratedGrossMinP = null;
  private ActivePower ratedNetMaxP = null;
  private Simple_Float shortPF = null;
  private Money startupCost = null;
  private PerCent totalEfficiency = null;
  private Money variableCost = null;

  private static final Logger LOGGER = Logger.getLogger(GeneratingUnitAggregate.class.getName());
}
