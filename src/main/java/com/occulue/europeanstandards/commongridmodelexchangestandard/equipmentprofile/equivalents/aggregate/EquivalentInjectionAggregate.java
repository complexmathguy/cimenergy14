package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.equivalents.aggregate;

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
 * Aggregate handler for EquivalentInjection as outlined for the CQRS pattern, all write
 * responsibilities related to EquivalentInjection are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class EquivalentInjectionAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public EquivalentInjectionAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public EquivalentInjectionAggregate(CreateEquivalentInjectionCommand command) throws Exception {
    LOGGER.info("Handling command CreateEquivalentInjectionCommand");
    CreateEquivalentInjectionEvent event =
        new CreateEquivalentInjectionEvent(command.getEquivalentInjectionId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateEquivalentInjectionCommand command) throws Exception {
    LOGGER.info("handling command UpdateEquivalentInjectionCommand");
    UpdateEquivalentInjectionEvent event =
        new UpdateEquivalentInjectionEvent(
            command.getEquivalentInjectionId(),
            command.getMaxP(),
            command.getMaxQ(),
            command.getMinP(),
            command.getMinQ(),
            command.getR(),
            command.getR0(),
            command.getR2(),
            command.getRegulationCapability(),
            command.getX(),
            command.getX0(),
            command.getX2(),
            command.getEquivalentInjection());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteEquivalentInjectionCommand command) throws Exception {
    LOGGER.info("Handling command DeleteEquivalentInjectionCommand");
    apply(new DeleteEquivalentInjectionEvent(command.getEquivalentInjectionId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignMaxPToEquivalentInjectionCommand command) throws Exception {
    LOGGER.info("Handling command AssignMaxPToEquivalentInjectionCommand");

    if (maxP != null && maxP.getActivePowerId() == command.getAssignment().getActivePowerId())
      throw new ProcessingException(
          "MaxP already assigned with id " + command.getAssignment().getActivePowerId());

    apply(
        new AssignMaxPToEquivalentInjectionEvent(
            command.getEquivalentInjectionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMaxPFromEquivalentInjectionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignMaxPFromEquivalentInjectionCommand");

    if (maxP == null) throw new ProcessingException("MaxP already has nothing assigned.");

    apply(new UnAssignMaxPFromEquivalentInjectionEvent(command.getEquivalentInjectionId()));
  }

  @CommandHandler
  public void handle(AssignMaxQToEquivalentInjectionCommand command) throws Exception {
    LOGGER.info("Handling command AssignMaxQToEquivalentInjectionCommand");

    if (maxQ != null && maxQ.getReactivePowerId() == command.getAssignment().getReactivePowerId())
      throw new ProcessingException(
          "MaxQ already assigned with id " + command.getAssignment().getReactivePowerId());

    apply(
        new AssignMaxQToEquivalentInjectionEvent(
            command.getEquivalentInjectionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMaxQFromEquivalentInjectionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignMaxQFromEquivalentInjectionCommand");

    if (maxQ == null) throw new ProcessingException("MaxQ already has nothing assigned.");

    apply(new UnAssignMaxQFromEquivalentInjectionEvent(command.getEquivalentInjectionId()));
  }

  @CommandHandler
  public void handle(AssignMinPToEquivalentInjectionCommand command) throws Exception {
    LOGGER.info("Handling command AssignMinPToEquivalentInjectionCommand");

    if (minP != null && minP.getActivePowerId() == command.getAssignment().getActivePowerId())
      throw new ProcessingException(
          "MinP already assigned with id " + command.getAssignment().getActivePowerId());

    apply(
        new AssignMinPToEquivalentInjectionEvent(
            command.getEquivalentInjectionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMinPFromEquivalentInjectionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignMinPFromEquivalentInjectionCommand");

    if (minP == null) throw new ProcessingException("MinP already has nothing assigned.");

    apply(new UnAssignMinPFromEquivalentInjectionEvent(command.getEquivalentInjectionId()));
  }

  @CommandHandler
  public void handle(AssignMinQToEquivalentInjectionCommand command) throws Exception {
    LOGGER.info("Handling command AssignMinQToEquivalentInjectionCommand");

    if (minQ != null && minQ.getReactivePowerId() == command.getAssignment().getReactivePowerId())
      throw new ProcessingException(
          "MinQ already assigned with id " + command.getAssignment().getReactivePowerId());

    apply(
        new AssignMinQToEquivalentInjectionEvent(
            command.getEquivalentInjectionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMinQFromEquivalentInjectionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignMinQFromEquivalentInjectionCommand");

    if (minQ == null) throw new ProcessingException("MinQ already has nothing assigned.");

    apply(new UnAssignMinQFromEquivalentInjectionEvent(command.getEquivalentInjectionId()));
  }

  @CommandHandler
  public void handle(AssignRToEquivalentInjectionCommand command) throws Exception {
    LOGGER.info("Handling command AssignRToEquivalentInjectionCommand");

    if (r != null && r.getResistanceId() == command.getAssignment().getResistanceId())
      throw new ProcessingException(
          "R already assigned with id " + command.getAssignment().getResistanceId());

    apply(
        new AssignRToEquivalentInjectionEvent(
            command.getEquivalentInjectionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRFromEquivalentInjectionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignRFromEquivalentInjectionCommand");

    if (r == null) throw new ProcessingException("R already has nothing assigned.");

    apply(new UnAssignRFromEquivalentInjectionEvent(command.getEquivalentInjectionId()));
  }

  @CommandHandler
  public void handle(AssignR0ToEquivalentInjectionCommand command) throws Exception {
    LOGGER.info("Handling command AssignR0ToEquivalentInjectionCommand");

    if (r0 != null && r0.getResistanceId() == command.getAssignment().getResistanceId())
      throw new ProcessingException(
          "R0 already assigned with id " + command.getAssignment().getResistanceId());

    apply(
        new AssignR0ToEquivalentInjectionEvent(
            command.getEquivalentInjectionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignR0FromEquivalentInjectionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignR0FromEquivalentInjectionCommand");

    if (r0 == null) throw new ProcessingException("R0 already has nothing assigned.");

    apply(new UnAssignR0FromEquivalentInjectionEvent(command.getEquivalentInjectionId()));
  }

  @CommandHandler
  public void handle(AssignR2ToEquivalentInjectionCommand command) throws Exception {
    LOGGER.info("Handling command AssignR2ToEquivalentInjectionCommand");

    if (r2 != null && r2.getResistanceId() == command.getAssignment().getResistanceId())
      throw new ProcessingException(
          "R2 already assigned with id " + command.getAssignment().getResistanceId());

    apply(
        new AssignR2ToEquivalentInjectionEvent(
            command.getEquivalentInjectionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignR2FromEquivalentInjectionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignR2FromEquivalentInjectionCommand");

    if (r2 == null) throw new ProcessingException("R2 already has nothing assigned.");

    apply(new UnAssignR2FromEquivalentInjectionEvent(command.getEquivalentInjectionId()));
  }

  @CommandHandler
  public void handle(AssignRegulationCapabilityToEquivalentInjectionCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignRegulationCapabilityToEquivalentInjectionCommand");

    if (regulationCapability != null
        && regulationCapability.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "RegulationCapability already assigned with id "
              + command.getAssignment().getBooleanProxyId());

    apply(
        new AssignRegulationCapabilityToEquivalentInjectionEvent(
            command.getEquivalentInjectionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRegulationCapabilityFromEquivalentInjectionCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignRegulationCapabilityFromEquivalentInjectionCommand");

    if (regulationCapability == null)
      throw new ProcessingException("RegulationCapability already has nothing assigned.");

    apply(
        new UnAssignRegulationCapabilityFromEquivalentInjectionEvent(
            command.getEquivalentInjectionId()));
  }

  @CommandHandler
  public void handle(AssignXToEquivalentInjectionCommand command) throws Exception {
    LOGGER.info("Handling command AssignXToEquivalentInjectionCommand");

    if (x != null && x.getReactanceId() == command.getAssignment().getReactanceId())
      throw new ProcessingException(
          "X already assigned with id " + command.getAssignment().getReactanceId());

    apply(
        new AssignXToEquivalentInjectionEvent(
            command.getEquivalentInjectionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignXFromEquivalentInjectionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignXFromEquivalentInjectionCommand");

    if (x == null) throw new ProcessingException("X already has nothing assigned.");

    apply(new UnAssignXFromEquivalentInjectionEvent(command.getEquivalentInjectionId()));
  }

  @CommandHandler
  public void handle(AssignX0ToEquivalentInjectionCommand command) throws Exception {
    LOGGER.info("Handling command AssignX0ToEquivalentInjectionCommand");

    if (x0 != null && x0.getReactanceId() == command.getAssignment().getReactanceId())
      throw new ProcessingException(
          "X0 already assigned with id " + command.getAssignment().getReactanceId());

    apply(
        new AssignX0ToEquivalentInjectionEvent(
            command.getEquivalentInjectionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignX0FromEquivalentInjectionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignX0FromEquivalentInjectionCommand");

    if (x0 == null) throw new ProcessingException("X0 already has nothing assigned.");

    apply(new UnAssignX0FromEquivalentInjectionEvent(command.getEquivalentInjectionId()));
  }

  @CommandHandler
  public void handle(AssignX2ToEquivalentInjectionCommand command) throws Exception {
    LOGGER.info("Handling command AssignX2ToEquivalentInjectionCommand");

    if (x2 != null && x2.getReactanceId() == command.getAssignment().getReactanceId())
      throw new ProcessingException(
          "X2 already assigned with id " + command.getAssignment().getReactanceId());

    apply(
        new AssignX2ToEquivalentInjectionEvent(
            command.getEquivalentInjectionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignX2FromEquivalentInjectionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignX2FromEquivalentInjectionCommand");

    if (x2 == null) throw new ProcessingException("X2 already has nothing assigned.");

    apply(new UnAssignX2FromEquivalentInjectionEvent(command.getEquivalentInjectionId()));
  }

  // multiple association commands
  @CommandHandler
  public void handle(AssignEquivalentInjectionToEquivalentInjectionCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignEquivalentInjectionToEquivalentInjectionCommand");

    if (equivalentInjection.contains(command.getAddTo()))
      throw new ProcessingException(
          "EquivalentInjection already contains an entity with id "
              + command.getAddTo().getEquivalentInjectionId());

    apply(
        new AssignEquivalentInjectionToEquivalentInjectionEvent(
            command.getEquivalentInjectionId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemoveEquivalentInjectionFromEquivalentInjectionCommand command)
      throws Exception {
    LOGGER.info("Handling command RemoveEquivalentInjectionFromEquivalentInjectionCommand");

    if (!equivalentInjection.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "EquivalentInjection does not contain an entity with id "
              + command.getRemoveFrom().getEquivalentInjectionId());

    apply(
        new RemoveEquivalentInjectionFromEquivalentInjectionEvent(
            command.getEquivalentInjectionId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateEquivalentInjectionEvent event) {
    LOGGER.info("Event sourcing CreateEquivalentInjectionEvent");
    this.equivalentInjectionId = event.getEquivalentInjectionId();
  }

  @EventSourcingHandler
  void on(UpdateEquivalentInjectionEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.maxP = event.getMaxP();
    this.maxQ = event.getMaxQ();
    this.minP = event.getMinP();
    this.minQ = event.getMinQ();
    this.r = event.getR();
    this.r0 = event.getR0();
    this.r2 = event.getR2();
    this.regulationCapability = event.getRegulationCapability();
    this.x = event.getX();
    this.x0 = event.getX0();
    this.x2 = event.getX2();
    this.equivalentInjection = event.getEquivalentInjection();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignMaxPToEquivalentInjectionEvent event) {
    LOGGER.info("Event sourcing AssignMaxPToEquivalentInjectionEvent");
    this.maxP = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMaxPFromEquivalentInjectionEvent event) {
    LOGGER.info("Event sourcing UnAssignMaxPFromEquivalentInjectionEvent");
    this.maxP = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMaxQToEquivalentInjectionEvent event) {
    LOGGER.info("Event sourcing AssignMaxQToEquivalentInjectionEvent");
    this.maxQ = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMaxQFromEquivalentInjectionEvent event) {
    LOGGER.info("Event sourcing UnAssignMaxQFromEquivalentInjectionEvent");
    this.maxQ = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMinPToEquivalentInjectionEvent event) {
    LOGGER.info("Event sourcing AssignMinPToEquivalentInjectionEvent");
    this.minP = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMinPFromEquivalentInjectionEvent event) {
    LOGGER.info("Event sourcing UnAssignMinPFromEquivalentInjectionEvent");
    this.minP = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMinQToEquivalentInjectionEvent event) {
    LOGGER.info("Event sourcing AssignMinQToEquivalentInjectionEvent");
    this.minQ = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMinQFromEquivalentInjectionEvent event) {
    LOGGER.info("Event sourcing UnAssignMinQFromEquivalentInjectionEvent");
    this.minQ = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRToEquivalentInjectionEvent event) {
    LOGGER.info("Event sourcing AssignRToEquivalentInjectionEvent");
    this.r = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRFromEquivalentInjectionEvent event) {
    LOGGER.info("Event sourcing UnAssignRFromEquivalentInjectionEvent");
    this.r = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignR0ToEquivalentInjectionEvent event) {
    LOGGER.info("Event sourcing AssignR0ToEquivalentInjectionEvent");
    this.r0 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignR0FromEquivalentInjectionEvent event) {
    LOGGER.info("Event sourcing UnAssignR0FromEquivalentInjectionEvent");
    this.r0 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignR2ToEquivalentInjectionEvent event) {
    LOGGER.info("Event sourcing AssignR2ToEquivalentInjectionEvent");
    this.r2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignR2FromEquivalentInjectionEvent event) {
    LOGGER.info("Event sourcing UnAssignR2FromEquivalentInjectionEvent");
    this.r2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRegulationCapabilityToEquivalentInjectionEvent event) {
    LOGGER.info("Event sourcing AssignRegulationCapabilityToEquivalentInjectionEvent");
    this.regulationCapability = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRegulationCapabilityFromEquivalentInjectionEvent event) {
    LOGGER.info("Event sourcing UnAssignRegulationCapabilityFromEquivalentInjectionEvent");
    this.regulationCapability = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignXToEquivalentInjectionEvent event) {
    LOGGER.info("Event sourcing AssignXToEquivalentInjectionEvent");
    this.x = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignXFromEquivalentInjectionEvent event) {
    LOGGER.info("Event sourcing UnAssignXFromEquivalentInjectionEvent");
    this.x = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignX0ToEquivalentInjectionEvent event) {
    LOGGER.info("Event sourcing AssignX0ToEquivalentInjectionEvent");
    this.x0 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignX0FromEquivalentInjectionEvent event) {
    LOGGER.info("Event sourcing UnAssignX0FromEquivalentInjectionEvent");
    this.x0 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignX2ToEquivalentInjectionEvent event) {
    LOGGER.info("Event sourcing AssignX2ToEquivalentInjectionEvent");
    this.x2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignX2FromEquivalentInjectionEvent event) {
    LOGGER.info("Event sourcing UnAssignX2FromEquivalentInjectionEvent");
    this.x2 = null;
  }

  // multiple associations
  @EventSourcingHandler
  void on(AssignEquivalentInjectionToEquivalentInjectionEvent event) {
    LOGGER.info("Event sourcing AssignEquivalentInjectionToEquivalentInjectionEvent");
    this.equivalentInjection.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveEquivalentInjectionFromEquivalentInjectionEvent event) {
    LOGGER.info("Event sourcing RemoveEquivalentInjectionFromEquivalentInjectionEvent");
    this.equivalentInjection.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID equivalentInjectionId;

  private ActivePower maxP = null;
  private ReactivePower maxQ = null;
  private ActivePower minP = null;
  private ReactivePower minQ = null;
  private Resistance r = null;
  private Resistance r0 = null;
  private Resistance r2 = null;
  private BooleanProxy regulationCapability = null;
  private Reactance x = null;
  private Reactance x0 = null;
  private Reactance x2 = null;
  private Set<EquivalentInjection> equivalentInjection = new HashSet<>();

  private static final Logger LOGGER =
      Logger.getLogger(EquivalentInjectionAggregate.class.getName());
}
