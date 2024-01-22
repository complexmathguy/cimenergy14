package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.mechanicalloaddynamics.aggregate;

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
 * Aggregate handler for MechLoad1 as outlined for the CQRS pattern, all write responsibilities
 * related to MechLoad1 are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class MechLoad1Aggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public MechLoad1Aggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public MechLoad1Aggregate(CreateMechLoad1Command command) throws Exception {
    LOGGER.info("Handling command CreateMechLoad1Command");
    CreateMechLoad1Event event = new CreateMechLoad1Event(command.getMechLoad1Id());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateMechLoad1Command command) throws Exception {
    LOGGER.info("handling command UpdateMechLoad1Command");
    UpdateMechLoad1Event event =
        new UpdateMechLoad1Event(
            command.getMechLoad1Id(),
            command.getA(),
            command.getB(),
            command.getD(),
            command.getE());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteMechLoad1Command command) throws Exception {
    LOGGER.info("Handling command DeleteMechLoad1Command");
    apply(new DeleteMechLoad1Event(command.getMechLoad1Id()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignAToMechLoad1Command command) throws Exception {
    LOGGER.info("Handling command AssignAToMechLoad1Command");

    if (a != null && a.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "A already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignAToMechLoad1Event(command.getMechLoad1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignAFromMechLoad1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignAFromMechLoad1Command");

    if (a == null) throw new ProcessingException("A already has nothing assigned.");

    apply(new UnAssignAFromMechLoad1Event(command.getMechLoad1Id()));
  }

  @CommandHandler
  public void handle(AssignBToMechLoad1Command command) throws Exception {
    LOGGER.info("Handling command AssignBToMechLoad1Command");

    if (b != null && b.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "B already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignBToMechLoad1Event(command.getMechLoad1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignBFromMechLoad1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignBFromMechLoad1Command");

    if (b == null) throw new ProcessingException("B already has nothing assigned.");

    apply(new UnAssignBFromMechLoad1Event(command.getMechLoad1Id()));
  }

  @CommandHandler
  public void handle(AssignDToMechLoad1Command command) throws Exception {
    LOGGER.info("Handling command AssignDToMechLoad1Command");

    if (d != null && d.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "D already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignDToMechLoad1Event(command.getMechLoad1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDFromMechLoad1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignDFromMechLoad1Command");

    if (d == null) throw new ProcessingException("D already has nothing assigned.");

    apply(new UnAssignDFromMechLoad1Event(command.getMechLoad1Id()));
  }

  @CommandHandler
  public void handle(AssignEToMechLoad1Command command) throws Exception {
    LOGGER.info("Handling command AssignEToMechLoad1Command");

    if (e != null && e.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "E already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignEToMechLoad1Event(command.getMechLoad1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEFromMechLoad1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignEFromMechLoad1Command");

    if (e == null) throw new ProcessingException("E already has nothing assigned.");

    apply(new UnAssignEFromMechLoad1Event(command.getMechLoad1Id()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateMechLoad1Event event) {
    LOGGER.info("Event sourcing CreateMechLoad1Event");
    this.mechLoad1Id = event.getMechLoad1Id();
  }

  @EventSourcingHandler
  void on(UpdateMechLoad1Event event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.a = event.getA();
    this.b = event.getB();
    this.d = event.getD();
    this.e = event.getE();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignAToMechLoad1Event event) {
    LOGGER.info("Event sourcing AssignAToMechLoad1Event");
    this.a = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignAFromMechLoad1Event event) {
    LOGGER.info("Event sourcing UnAssignAFromMechLoad1Event");
    this.a = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignBToMechLoad1Event event) {
    LOGGER.info("Event sourcing AssignBToMechLoad1Event");
    this.b = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignBFromMechLoad1Event event) {
    LOGGER.info("Event sourcing UnAssignBFromMechLoad1Event");
    this.b = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDToMechLoad1Event event) {
    LOGGER.info("Event sourcing AssignDToMechLoad1Event");
    this.d = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDFromMechLoad1Event event) {
    LOGGER.info("Event sourcing UnAssignDFromMechLoad1Event");
    this.d = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEToMechLoad1Event event) {
    LOGGER.info("Event sourcing AssignEToMechLoad1Event");
    this.e = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEFromMechLoad1Event event) {
    LOGGER.info("Event sourcing UnAssignEFromMechLoad1Event");
    this.e = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID mechLoad1Id;

  private Simple_Float a = null;
  private Simple_Float b = null;
  private Simple_Float d = null;
  private Simple_Float e = null;

  private static final Logger LOGGER = Logger.getLogger(MechLoad1Aggregate.class.getName());
}
