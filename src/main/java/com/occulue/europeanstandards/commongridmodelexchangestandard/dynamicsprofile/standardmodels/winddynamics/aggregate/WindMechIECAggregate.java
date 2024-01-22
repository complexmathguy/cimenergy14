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
 * Aggregate handler for WindMechIEC as outlined for the CQRS pattern, all write responsibilities
 * related to WindMechIEC are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class WindMechIECAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public WindMechIECAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public WindMechIECAggregate(CreateWindMechIECCommand command) throws Exception {
    LOGGER.info("Handling command CreateWindMechIECCommand");
    CreateWindMechIECEvent event = new CreateWindMechIECEvent(command.getWindMechIECId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateWindMechIECCommand command) throws Exception {
    LOGGER.info("handling command UpdateWindMechIECCommand");
    UpdateWindMechIECEvent event =
        new UpdateWindMechIECEvent(
            command.getWindMechIECId(),
            command.getCdrt(),
            command.getHgen(),
            command.getHwtr(),
            command.getKdrt());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteWindMechIECCommand command) throws Exception {
    LOGGER.info("Handling command DeleteWindMechIECCommand");
    apply(new DeleteWindMechIECEvent(command.getWindMechIECId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignCdrtToWindMechIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignCdrtToWindMechIECCommand");

    if (cdrt != null && cdrt.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Cdrt already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignCdrtToWindMechIECEvent(command.getWindMechIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignCdrtFromWindMechIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignCdrtFromWindMechIECCommand");

    if (cdrt == null) throw new ProcessingException("Cdrt already has nothing assigned.");

    apply(new UnAssignCdrtFromWindMechIECEvent(command.getWindMechIECId()));
  }

  @CommandHandler
  public void handle(AssignHgenToWindMechIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignHgenToWindMechIECCommand");

    if (hgen != null && hgen.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Hgen already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignHgenToWindMechIECEvent(command.getWindMechIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignHgenFromWindMechIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignHgenFromWindMechIECCommand");

    if (hgen == null) throw new ProcessingException("Hgen already has nothing assigned.");

    apply(new UnAssignHgenFromWindMechIECEvent(command.getWindMechIECId()));
  }

  @CommandHandler
  public void handle(AssignHwtrToWindMechIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignHwtrToWindMechIECCommand");

    if (hwtr != null && hwtr.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Hwtr already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignHwtrToWindMechIECEvent(command.getWindMechIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignHwtrFromWindMechIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignHwtrFromWindMechIECCommand");

    if (hwtr == null) throw new ProcessingException("Hwtr already has nothing assigned.");

    apply(new UnAssignHwtrFromWindMechIECEvent(command.getWindMechIECId()));
  }

  @CommandHandler
  public void handle(AssignKdrtToWindMechIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignKdrtToWindMechIECCommand");

    if (kdrt != null && kdrt.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kdrt already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKdrtToWindMechIECEvent(command.getWindMechIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKdrtFromWindMechIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKdrtFromWindMechIECCommand");

    if (kdrt == null) throw new ProcessingException("Kdrt already has nothing assigned.");

    apply(new UnAssignKdrtFromWindMechIECEvent(command.getWindMechIECId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateWindMechIECEvent event) {
    LOGGER.info("Event sourcing CreateWindMechIECEvent");
    this.windMechIECId = event.getWindMechIECId();
  }

  @EventSourcingHandler
  void on(UpdateWindMechIECEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.cdrt = event.getCdrt();
    this.hgen = event.getHgen();
    this.hwtr = event.getHwtr();
    this.kdrt = event.getKdrt();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignCdrtToWindMechIECEvent event) {
    LOGGER.info("Event sourcing AssignCdrtToWindMechIECEvent");
    this.cdrt = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignCdrtFromWindMechIECEvent event) {
    LOGGER.info("Event sourcing UnAssignCdrtFromWindMechIECEvent");
    this.cdrt = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignHgenToWindMechIECEvent event) {
    LOGGER.info("Event sourcing AssignHgenToWindMechIECEvent");
    this.hgen = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignHgenFromWindMechIECEvent event) {
    LOGGER.info("Event sourcing UnAssignHgenFromWindMechIECEvent");
    this.hgen = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignHwtrToWindMechIECEvent event) {
    LOGGER.info("Event sourcing AssignHwtrToWindMechIECEvent");
    this.hwtr = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignHwtrFromWindMechIECEvent event) {
    LOGGER.info("Event sourcing UnAssignHwtrFromWindMechIECEvent");
    this.hwtr = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKdrtToWindMechIECEvent event) {
    LOGGER.info("Event sourcing AssignKdrtToWindMechIECEvent");
    this.kdrt = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKdrtFromWindMechIECEvent event) {
    LOGGER.info("Event sourcing UnAssignKdrtFromWindMechIECEvent");
    this.kdrt = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID windMechIECId;

  private PU cdrt = null;
  private Seconds hgen = null;
  private Seconds hwtr = null;
  private PU kdrt = null;

  private static final Logger LOGGER = Logger.getLogger(WindMechIECAggregate.class.getName());
}
