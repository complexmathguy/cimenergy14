package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.aggregate;

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
 * Aggregate handler for WindGenType4IEC as outlined for the CQRS pattern, all write
 * responsibilities related to WindGenType4IEC are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class WindGenType4IECAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public WindGenType4IECAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public WindGenType4IECAggregate(CreateWindGenType4IECCommand command) throws Exception {
    LOGGER.info("Handling command CreateWindGenType4IECCommand");
    CreateWindGenType4IECEvent event =
        new CreateWindGenType4IECEvent(command.getWindGenType4IECId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateWindGenType4IECCommand command) throws Exception {
    LOGGER.info("handling command UpdateWindGenType4IECCommand");
    UpdateWindGenType4IECEvent event =
        new UpdateWindGenType4IECEvent(
            command.getWindGenType4IECId(),
            command.getDipmax(),
            command.getDiqmax(),
            command.getDiqmin(),
            command.getTg());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteWindGenType4IECCommand command) throws Exception {
    LOGGER.info("Handling command DeleteWindGenType4IECCommand");
    apply(new DeleteWindGenType4IECEvent(command.getWindGenType4IECId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignDipmaxToWindGenType4IECCommand command) throws Exception {
    LOGGER.info("Handling command AssignDipmaxToWindGenType4IECCommand");

    if (dipmax != null && dipmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Dipmax already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignDipmaxToWindGenType4IECEvent(
            command.getWindGenType4IECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDipmaxFromWindGenType4IECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignDipmaxFromWindGenType4IECCommand");

    if (dipmax == null) throw new ProcessingException("Dipmax already has nothing assigned.");

    apply(new UnAssignDipmaxFromWindGenType4IECEvent(command.getWindGenType4IECId()));
  }

  @CommandHandler
  public void handle(AssignDiqmaxToWindGenType4IECCommand command) throws Exception {
    LOGGER.info("Handling command AssignDiqmaxToWindGenType4IECCommand");

    if (diqmax != null && diqmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Diqmax already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignDiqmaxToWindGenType4IECEvent(
            command.getWindGenType4IECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDiqmaxFromWindGenType4IECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignDiqmaxFromWindGenType4IECCommand");

    if (diqmax == null) throw new ProcessingException("Diqmax already has nothing assigned.");

    apply(new UnAssignDiqmaxFromWindGenType4IECEvent(command.getWindGenType4IECId()));
  }

  @CommandHandler
  public void handle(AssignDiqminToWindGenType4IECCommand command) throws Exception {
    LOGGER.info("Handling command AssignDiqminToWindGenType4IECCommand");

    if (diqmin != null && diqmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Diqmin already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignDiqminToWindGenType4IECEvent(
            command.getWindGenType4IECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDiqminFromWindGenType4IECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignDiqminFromWindGenType4IECCommand");

    if (diqmin == null) throw new ProcessingException("Diqmin already has nothing assigned.");

    apply(new UnAssignDiqminFromWindGenType4IECEvent(command.getWindGenType4IECId()));
  }

  @CommandHandler
  public void handle(AssignTgToWindGenType4IECCommand command) throws Exception {
    LOGGER.info("Handling command AssignTgToWindGenType4IECCommand");

    if (tg != null && tg.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tg already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTgToWindGenType4IECEvent(
            command.getWindGenType4IECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTgFromWindGenType4IECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTgFromWindGenType4IECCommand");

    if (tg == null) throw new ProcessingException("Tg already has nothing assigned.");

    apply(new UnAssignTgFromWindGenType4IECEvent(command.getWindGenType4IECId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateWindGenType4IECEvent event) {
    LOGGER.info("Event sourcing CreateWindGenType4IECEvent");
    this.windGenType4IECId = event.getWindGenType4IECId();
  }

  @EventSourcingHandler
  void on(UpdateWindGenType4IECEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.dipmax = event.getDipmax();
    this.diqmax = event.getDiqmax();
    this.diqmin = event.getDiqmin();
    this.tg = event.getTg();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignDipmaxToWindGenType4IECEvent event) {
    LOGGER.info("Event sourcing AssignDipmaxToWindGenType4IECEvent");
    this.dipmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDipmaxFromWindGenType4IECEvent event) {
    LOGGER.info("Event sourcing UnAssignDipmaxFromWindGenType4IECEvent");
    this.dipmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDiqmaxToWindGenType4IECEvent event) {
    LOGGER.info("Event sourcing AssignDiqmaxToWindGenType4IECEvent");
    this.diqmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDiqmaxFromWindGenType4IECEvent event) {
    LOGGER.info("Event sourcing UnAssignDiqmaxFromWindGenType4IECEvent");
    this.diqmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDiqminToWindGenType4IECEvent event) {
    LOGGER.info("Event sourcing AssignDiqminToWindGenType4IECEvent");
    this.diqmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDiqminFromWindGenType4IECEvent event) {
    LOGGER.info("Event sourcing UnAssignDiqminFromWindGenType4IECEvent");
    this.diqmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTgToWindGenType4IECEvent event) {
    LOGGER.info("Event sourcing AssignTgToWindGenType4IECEvent");
    this.tg = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTgFromWindGenType4IECEvent event) {
    LOGGER.info("Event sourcing UnAssignTgFromWindGenType4IECEvent");
    this.tg = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID windGenType4IECId;

  private PU dipmax = null;
  private PU diqmax = null;
  private PU diqmin = null;
  private Seconds tg = null;

  private static final Logger LOGGER = Logger.getLogger(WindGenType4IECAggregate.class.getName());
}
