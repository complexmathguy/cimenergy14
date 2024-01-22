package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.aggregate;

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
 * Aggregate handler for TapChanger as outlined for the CQRS pattern, all write responsibilities
 * related to TapChanger are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class TapChangerAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public TapChangerAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public TapChangerAggregate(CreateTapChangerCommand command) throws Exception {
    LOGGER.info("Handling command CreateTapChangerCommand");
    CreateTapChangerEvent event = new CreateTapChangerEvent(command.getTapChangerId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateTapChangerCommand command) throws Exception {
    LOGGER.info("handling command UpdateTapChangerCommand");
    UpdateTapChangerEvent event =
        new UpdateTapChangerEvent(
            command.getTapChangerId(),
            command.getHighStep(),
            command.getLowStep(),
            command.getLtcFlag(),
            command.getNeutralStep(),
            command.getNeutralU(),
            command.getNormalStep(),
            command.getTapChanger());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteTapChangerCommand command) throws Exception {
    LOGGER.info("Handling command DeleteTapChangerCommand");
    apply(new DeleteTapChangerEvent(command.getTapChangerId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignHighStepToTapChangerCommand command) throws Exception {
    LOGGER.info("Handling command AssignHighStepToTapChangerCommand");

    if (highStep != null
        && highStep.getIntegerProxyId() == command.getAssignment().getIntegerProxyId())
      throw new ProcessingException(
          "HighStep already assigned with id " + command.getAssignment().getIntegerProxyId());

    apply(new AssignHighStepToTapChangerEvent(command.getTapChangerId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignHighStepFromTapChangerCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignHighStepFromTapChangerCommand");

    if (highStep == null) throw new ProcessingException("HighStep already has nothing assigned.");

    apply(new UnAssignHighStepFromTapChangerEvent(command.getTapChangerId()));
  }

  @CommandHandler
  public void handle(AssignLowStepToTapChangerCommand command) throws Exception {
    LOGGER.info("Handling command AssignLowStepToTapChangerCommand");

    if (lowStep != null
        && lowStep.getIntegerProxyId() == command.getAssignment().getIntegerProxyId())
      throw new ProcessingException(
          "LowStep already assigned with id " + command.getAssignment().getIntegerProxyId());

    apply(new AssignLowStepToTapChangerEvent(command.getTapChangerId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignLowStepFromTapChangerCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignLowStepFromTapChangerCommand");

    if (lowStep == null) throw new ProcessingException("LowStep already has nothing assigned.");

    apply(new UnAssignLowStepFromTapChangerEvent(command.getTapChangerId()));
  }

  @CommandHandler
  public void handle(AssignLtcFlagToTapChangerCommand command) throws Exception {
    LOGGER.info("Handling command AssignLtcFlagToTapChangerCommand");

    if (ltcFlag != null
        && ltcFlag.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "LtcFlag already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(new AssignLtcFlagToTapChangerEvent(command.getTapChangerId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignLtcFlagFromTapChangerCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignLtcFlagFromTapChangerCommand");

    if (ltcFlag == null) throw new ProcessingException("LtcFlag already has nothing assigned.");

    apply(new UnAssignLtcFlagFromTapChangerEvent(command.getTapChangerId()));
  }

  @CommandHandler
  public void handle(AssignNeutralStepToTapChangerCommand command) throws Exception {
    LOGGER.info("Handling command AssignNeutralStepToTapChangerCommand");

    if (neutralStep != null
        && neutralStep.getIntegerProxyId() == command.getAssignment().getIntegerProxyId())
      throw new ProcessingException(
          "NeutralStep already assigned with id " + command.getAssignment().getIntegerProxyId());

    apply(
        new AssignNeutralStepToTapChangerEvent(command.getTapChangerId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignNeutralStepFromTapChangerCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignNeutralStepFromTapChangerCommand");

    if (neutralStep == null)
      throw new ProcessingException("NeutralStep already has nothing assigned.");

    apply(new UnAssignNeutralStepFromTapChangerEvent(command.getTapChangerId()));
  }

  @CommandHandler
  public void handle(AssignNeutralUToTapChangerCommand command) throws Exception {
    LOGGER.info("Handling command AssignNeutralUToTapChangerCommand");

    if (neutralU != null && neutralU.getVoltageId() == command.getAssignment().getVoltageId())
      throw new ProcessingException(
          "NeutralU already assigned with id " + command.getAssignment().getVoltageId());

    apply(new AssignNeutralUToTapChangerEvent(command.getTapChangerId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignNeutralUFromTapChangerCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignNeutralUFromTapChangerCommand");

    if (neutralU == null) throw new ProcessingException("NeutralU already has nothing assigned.");

    apply(new UnAssignNeutralUFromTapChangerEvent(command.getTapChangerId()));
  }

  @CommandHandler
  public void handle(AssignNormalStepToTapChangerCommand command) throws Exception {
    LOGGER.info("Handling command AssignNormalStepToTapChangerCommand");

    if (normalStep != null
        && normalStep.getIntegerProxyId() == command.getAssignment().getIntegerProxyId())
      throw new ProcessingException(
          "NormalStep already assigned with id " + command.getAssignment().getIntegerProxyId());

    apply(
        new AssignNormalStepToTapChangerEvent(command.getTapChangerId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignNormalStepFromTapChangerCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignNormalStepFromTapChangerCommand");

    if (normalStep == null)
      throw new ProcessingException("NormalStep already has nothing assigned.");

    apply(new UnAssignNormalStepFromTapChangerEvent(command.getTapChangerId()));
  }

  // multiple association commands
  @CommandHandler
  public void handle(AssignTapChangerToTapChangerCommand command) throws Exception {
    LOGGER.info("Handling command AssignTapChangerToTapChangerCommand");

    if (tapChanger.contains(command.getAddTo()))
      throw new ProcessingException(
          "TapChanger already contains an entity with id " + command.getAddTo().getTapChangerId());

    apply(new AssignTapChangerToTapChangerEvent(command.getTapChangerId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemoveTapChangerFromTapChangerCommand command) throws Exception {
    LOGGER.info("Handling command RemoveTapChangerFromTapChangerCommand");

    if (!tapChanger.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "TapChanger does not contain an entity with id "
              + command.getRemoveFrom().getTapChangerId());

    apply(
        new RemoveTapChangerFromTapChangerEvent(
            command.getTapChangerId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateTapChangerEvent event) {
    LOGGER.info("Event sourcing CreateTapChangerEvent");
    this.tapChangerId = event.getTapChangerId();
  }

  @EventSourcingHandler
  void on(UpdateTapChangerEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.highStep = event.getHighStep();
    this.lowStep = event.getLowStep();
    this.ltcFlag = event.getLtcFlag();
    this.neutralStep = event.getNeutralStep();
    this.neutralU = event.getNeutralU();
    this.normalStep = event.getNormalStep();
    this.tapChanger = event.getTapChanger();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignHighStepToTapChangerEvent event) {
    LOGGER.info("Event sourcing AssignHighStepToTapChangerEvent");
    this.highStep = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignHighStepFromTapChangerEvent event) {
    LOGGER.info("Event sourcing UnAssignHighStepFromTapChangerEvent");
    this.highStep = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignLowStepToTapChangerEvent event) {
    LOGGER.info("Event sourcing AssignLowStepToTapChangerEvent");
    this.lowStep = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignLowStepFromTapChangerEvent event) {
    LOGGER.info("Event sourcing UnAssignLowStepFromTapChangerEvent");
    this.lowStep = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignLtcFlagToTapChangerEvent event) {
    LOGGER.info("Event sourcing AssignLtcFlagToTapChangerEvent");
    this.ltcFlag = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignLtcFlagFromTapChangerEvent event) {
    LOGGER.info("Event sourcing UnAssignLtcFlagFromTapChangerEvent");
    this.ltcFlag = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignNeutralStepToTapChangerEvent event) {
    LOGGER.info("Event sourcing AssignNeutralStepToTapChangerEvent");
    this.neutralStep = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignNeutralStepFromTapChangerEvent event) {
    LOGGER.info("Event sourcing UnAssignNeutralStepFromTapChangerEvent");
    this.neutralStep = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignNeutralUToTapChangerEvent event) {
    LOGGER.info("Event sourcing AssignNeutralUToTapChangerEvent");
    this.neutralU = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignNeutralUFromTapChangerEvent event) {
    LOGGER.info("Event sourcing UnAssignNeutralUFromTapChangerEvent");
    this.neutralU = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignNormalStepToTapChangerEvent event) {
    LOGGER.info("Event sourcing AssignNormalStepToTapChangerEvent");
    this.normalStep = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignNormalStepFromTapChangerEvent event) {
    LOGGER.info("Event sourcing UnAssignNormalStepFromTapChangerEvent");
    this.normalStep = null;
  }

  // multiple associations
  @EventSourcingHandler
  void on(AssignTapChangerToTapChangerEvent event) {
    LOGGER.info("Event sourcing AssignTapChangerToTapChangerEvent");
    this.tapChanger.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveTapChangerFromTapChangerEvent event) {
    LOGGER.info("Event sourcing RemoveTapChangerFromTapChangerEvent");
    this.tapChanger.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID tapChangerId;

  private IntegerProxy highStep = null;
  private IntegerProxy lowStep = null;
  private BooleanProxy ltcFlag = null;
  private IntegerProxy neutralStep = null;
  private Voltage neutralU = null;
  private IntegerProxy normalStep = null;
  private Set<TapChanger> tapChanger = new HashSet<>();

  private static final Logger LOGGER = Logger.getLogger(TapChangerAggregate.class.getName());
}
