package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.voltagecompensatordynamics.aggregate;

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
 * Aggregate handler for VCompIEEEType1 as outlined for the CQRS pattern, all write responsibilities
 * related to VCompIEEEType1 are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class VCompIEEEType1Aggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public VCompIEEEType1Aggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public VCompIEEEType1Aggregate(CreateVCompIEEEType1Command command) throws Exception {
    LOGGER.info("Handling command CreateVCompIEEEType1Command");
    CreateVCompIEEEType1Event event = new CreateVCompIEEEType1Event(command.getVCompIEEEType1Id());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateVCompIEEEType1Command command) throws Exception {
    LOGGER.info("handling command UpdateVCompIEEEType1Command");
    UpdateVCompIEEEType1Event event =
        new UpdateVCompIEEEType1Event(
            command.getVCompIEEEType1Id(), command.getRc(), command.getTr(), command.getXc());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteVCompIEEEType1Command command) throws Exception {
    LOGGER.info("Handling command DeleteVCompIEEEType1Command");
    apply(new DeleteVCompIEEEType1Event(command.getVCompIEEEType1Id()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignRcToVCompIEEEType1Command command) throws Exception {
    LOGGER.info("Handling command AssignRcToVCompIEEEType1Command");

    if (rc != null && rc.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Rc already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignRcToVCompIEEEType1Event(command.getVCompIEEEType1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRcFromVCompIEEEType1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignRcFromVCompIEEEType1Command");

    if (rc == null) throw new ProcessingException("Rc already has nothing assigned.");

    apply(new UnAssignRcFromVCompIEEEType1Event(command.getVCompIEEEType1Id()));
  }

  @CommandHandler
  public void handle(AssignTrToVCompIEEEType1Command command) throws Exception {
    LOGGER.info("Handling command AssignTrToVCompIEEEType1Command");

    if (tr != null && tr.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tr already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTrToVCompIEEEType1Event(command.getVCompIEEEType1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTrFromVCompIEEEType1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTrFromVCompIEEEType1Command");

    if (tr == null) throw new ProcessingException("Tr already has nothing assigned.");

    apply(new UnAssignTrFromVCompIEEEType1Event(command.getVCompIEEEType1Id()));
  }

  @CommandHandler
  public void handle(AssignXcToVCompIEEEType1Command command) throws Exception {
    LOGGER.info("Handling command AssignXcToVCompIEEEType1Command");

    if (xc != null && xc.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Xc already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignXcToVCompIEEEType1Event(command.getVCompIEEEType1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignXcFromVCompIEEEType1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignXcFromVCompIEEEType1Command");

    if (xc == null) throw new ProcessingException("Xc already has nothing assigned.");

    apply(new UnAssignXcFromVCompIEEEType1Event(command.getVCompIEEEType1Id()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateVCompIEEEType1Event event) {
    LOGGER.info("Event sourcing CreateVCompIEEEType1Event");
    this.vCompIEEEType1Id = event.getVCompIEEEType1Id();
  }

  @EventSourcingHandler
  void on(UpdateVCompIEEEType1Event event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.rc = event.getRc();
    this.tr = event.getTr();
    this.xc = event.getXc();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignRcToVCompIEEEType1Event event) {
    LOGGER.info("Event sourcing AssignRcToVCompIEEEType1Event");
    this.rc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRcFromVCompIEEEType1Event event) {
    LOGGER.info("Event sourcing UnAssignRcFromVCompIEEEType1Event");
    this.rc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTrToVCompIEEEType1Event event) {
    LOGGER.info("Event sourcing AssignTrToVCompIEEEType1Event");
    this.tr = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTrFromVCompIEEEType1Event event) {
    LOGGER.info("Event sourcing UnAssignTrFromVCompIEEEType1Event");
    this.tr = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignXcToVCompIEEEType1Event event) {
    LOGGER.info("Event sourcing AssignXcToVCompIEEEType1Event");
    this.xc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignXcFromVCompIEEEType1Event event) {
    LOGGER.info("Event sourcing UnAssignXcFromVCompIEEEType1Event");
    this.xc = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID vCompIEEEType1Id;

  private PU rc = null;
  private Seconds tr = null;
  private PU xc = null;

  private static final Logger LOGGER = Logger.getLogger(VCompIEEEType1Aggregate.class.getName());
}
