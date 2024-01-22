package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.aggregate;

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
 * Aggregate handler for DCShunt as outlined for the CQRS pattern, all write responsibilities
 * related to DCShunt are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class DCShuntAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public DCShuntAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public DCShuntAggregate(CreateDCShuntCommand command) throws Exception {
    LOGGER.info("Handling command CreateDCShuntCommand");
    CreateDCShuntEvent event = new CreateDCShuntEvent(command.getDCShuntId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateDCShuntCommand command) throws Exception {
    LOGGER.info("handling command UpdateDCShuntCommand");
    UpdateDCShuntEvent event =
        new UpdateDCShuntEvent(
            command.getDCShuntId(),
            command.getCapacitance(),
            command.getRatedUdc(),
            command.getResistance());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteDCShuntCommand command) throws Exception {
    LOGGER.info("Handling command DeleteDCShuntCommand");
    apply(new DeleteDCShuntEvent(command.getDCShuntId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignCapacitanceToDCShuntCommand command) throws Exception {
    LOGGER.info("Handling command AssignCapacitanceToDCShuntCommand");

    if (capacitance != null
        && capacitance.getCapacitanceId() == command.getAssignment().getCapacitanceId())
      throw new ProcessingException(
          "Capacitance already assigned with id " + command.getAssignment().getCapacitanceId());

    apply(new AssignCapacitanceToDCShuntEvent(command.getDCShuntId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignCapacitanceFromDCShuntCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignCapacitanceFromDCShuntCommand");

    if (capacitance == null)
      throw new ProcessingException("Capacitance already has nothing assigned.");

    apply(new UnAssignCapacitanceFromDCShuntEvent(command.getDCShuntId()));
  }

  @CommandHandler
  public void handle(AssignRatedUdcToDCShuntCommand command) throws Exception {
    LOGGER.info("Handling command AssignRatedUdcToDCShuntCommand");

    if (ratedUdc != null && ratedUdc.getVoltageId() == command.getAssignment().getVoltageId())
      throw new ProcessingException(
          "RatedUdc already assigned with id " + command.getAssignment().getVoltageId());

    apply(new AssignRatedUdcToDCShuntEvent(command.getDCShuntId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRatedUdcFromDCShuntCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignRatedUdcFromDCShuntCommand");

    if (ratedUdc == null) throw new ProcessingException("RatedUdc already has nothing assigned.");

    apply(new UnAssignRatedUdcFromDCShuntEvent(command.getDCShuntId()));
  }

  @CommandHandler
  public void handle(AssignResistanceToDCShuntCommand command) throws Exception {
    LOGGER.info("Handling command AssignResistanceToDCShuntCommand");

    if (resistance != null
        && resistance.getResistanceId() == command.getAssignment().getResistanceId())
      throw new ProcessingException(
          "Resistance already assigned with id " + command.getAssignment().getResistanceId());

    apply(new AssignResistanceToDCShuntEvent(command.getDCShuntId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignResistanceFromDCShuntCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignResistanceFromDCShuntCommand");

    if (resistance == null)
      throw new ProcessingException("Resistance already has nothing assigned.");

    apply(new UnAssignResistanceFromDCShuntEvent(command.getDCShuntId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateDCShuntEvent event) {
    LOGGER.info("Event sourcing CreateDCShuntEvent");
    this.dCShuntId = event.getDCShuntId();
  }

  @EventSourcingHandler
  void on(UpdateDCShuntEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.capacitance = event.getCapacitance();
    this.ratedUdc = event.getRatedUdc();
    this.resistance = event.getResistance();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignCapacitanceToDCShuntEvent event) {
    LOGGER.info("Event sourcing AssignCapacitanceToDCShuntEvent");
    this.capacitance = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignCapacitanceFromDCShuntEvent event) {
    LOGGER.info("Event sourcing UnAssignCapacitanceFromDCShuntEvent");
    this.capacitance = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRatedUdcToDCShuntEvent event) {
    LOGGER.info("Event sourcing AssignRatedUdcToDCShuntEvent");
    this.ratedUdc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRatedUdcFromDCShuntEvent event) {
    LOGGER.info("Event sourcing UnAssignRatedUdcFromDCShuntEvent");
    this.ratedUdc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignResistanceToDCShuntEvent event) {
    LOGGER.info("Event sourcing AssignResistanceToDCShuntEvent");
    this.resistance = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignResistanceFromDCShuntEvent event) {
    LOGGER.info("Event sourcing UnAssignResistanceFromDCShuntEvent");
    this.resistance = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID dCShuntId;

  private Capacitance capacitance = null;
  private Voltage ratedUdc = null;
  private Resistance resistance = null;

  private static final Logger LOGGER = Logger.getLogger(DCShuntAggregate.class.getName());
}
