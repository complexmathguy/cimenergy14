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
 * Aggregate handler for DCSeriesDevice as outlined for the CQRS pattern, all write responsibilities
 * related to DCSeriesDevice are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class DCSeriesDeviceAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public DCSeriesDeviceAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public DCSeriesDeviceAggregate(CreateDCSeriesDeviceCommand command) throws Exception {
    LOGGER.info("Handling command CreateDCSeriesDeviceCommand");
    CreateDCSeriesDeviceEvent event = new CreateDCSeriesDeviceEvent(command.getDCSeriesDeviceId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateDCSeriesDeviceCommand command) throws Exception {
    LOGGER.info("handling command UpdateDCSeriesDeviceCommand");
    UpdateDCSeriesDeviceEvent event =
        new UpdateDCSeriesDeviceEvent(
            command.getDCSeriesDeviceId(),
            command.getInductance(),
            command.getRatedUdc(),
            command.getResistance());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteDCSeriesDeviceCommand command) throws Exception {
    LOGGER.info("Handling command DeleteDCSeriesDeviceCommand");
    apply(new DeleteDCSeriesDeviceEvent(command.getDCSeriesDeviceId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignInductanceToDCSeriesDeviceCommand command) throws Exception {
    LOGGER.info("Handling command AssignInductanceToDCSeriesDeviceCommand");

    if (inductance != null
        && inductance.getInductanceId() == command.getAssignment().getInductanceId())
      throw new ProcessingException(
          "Inductance already assigned with id " + command.getAssignment().getInductanceId());

    apply(
        new AssignInductanceToDCSeriesDeviceEvent(
            command.getDCSeriesDeviceId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignInductanceFromDCSeriesDeviceCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignInductanceFromDCSeriesDeviceCommand");

    if (inductance == null)
      throw new ProcessingException("Inductance already has nothing assigned.");

    apply(new UnAssignInductanceFromDCSeriesDeviceEvent(command.getDCSeriesDeviceId()));
  }

  @CommandHandler
  public void handle(AssignRatedUdcToDCSeriesDeviceCommand command) throws Exception {
    LOGGER.info("Handling command AssignRatedUdcToDCSeriesDeviceCommand");

    if (ratedUdc != null && ratedUdc.getVoltageId() == command.getAssignment().getVoltageId())
      throw new ProcessingException(
          "RatedUdc already assigned with id " + command.getAssignment().getVoltageId());

    apply(
        new AssignRatedUdcToDCSeriesDeviceEvent(
            command.getDCSeriesDeviceId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRatedUdcFromDCSeriesDeviceCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignRatedUdcFromDCSeriesDeviceCommand");

    if (ratedUdc == null) throw new ProcessingException("RatedUdc already has nothing assigned.");

    apply(new UnAssignRatedUdcFromDCSeriesDeviceEvent(command.getDCSeriesDeviceId()));
  }

  @CommandHandler
  public void handle(AssignResistanceToDCSeriesDeviceCommand command) throws Exception {
    LOGGER.info("Handling command AssignResistanceToDCSeriesDeviceCommand");

    if (resistance != null
        && resistance.getResistanceId() == command.getAssignment().getResistanceId())
      throw new ProcessingException(
          "Resistance already assigned with id " + command.getAssignment().getResistanceId());

    apply(
        new AssignResistanceToDCSeriesDeviceEvent(
            command.getDCSeriesDeviceId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignResistanceFromDCSeriesDeviceCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignResistanceFromDCSeriesDeviceCommand");

    if (resistance == null)
      throw new ProcessingException("Resistance already has nothing assigned.");

    apply(new UnAssignResistanceFromDCSeriesDeviceEvent(command.getDCSeriesDeviceId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateDCSeriesDeviceEvent event) {
    LOGGER.info("Event sourcing CreateDCSeriesDeviceEvent");
    this.dCSeriesDeviceId = event.getDCSeriesDeviceId();
  }

  @EventSourcingHandler
  void on(UpdateDCSeriesDeviceEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.inductance = event.getInductance();
    this.ratedUdc = event.getRatedUdc();
    this.resistance = event.getResistance();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignInductanceToDCSeriesDeviceEvent event) {
    LOGGER.info("Event sourcing AssignInductanceToDCSeriesDeviceEvent");
    this.inductance = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignInductanceFromDCSeriesDeviceEvent event) {
    LOGGER.info("Event sourcing UnAssignInductanceFromDCSeriesDeviceEvent");
    this.inductance = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRatedUdcToDCSeriesDeviceEvent event) {
    LOGGER.info("Event sourcing AssignRatedUdcToDCSeriesDeviceEvent");
    this.ratedUdc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRatedUdcFromDCSeriesDeviceEvent event) {
    LOGGER.info("Event sourcing UnAssignRatedUdcFromDCSeriesDeviceEvent");
    this.ratedUdc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignResistanceToDCSeriesDeviceEvent event) {
    LOGGER.info("Event sourcing AssignResistanceToDCSeriesDeviceEvent");
    this.resistance = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignResistanceFromDCSeriesDeviceEvent event) {
    LOGGER.info("Event sourcing UnAssignResistanceFromDCSeriesDeviceEvent");
    this.resistance = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID dCSeriesDeviceId;

  private Inductance inductance = null;
  private Voltage ratedUdc = null;
  private Resistance resistance = null;

  private static final Logger LOGGER = Logger.getLogger(DCSeriesDeviceAggregate.class.getName());
}
