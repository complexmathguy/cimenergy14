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
 * Aggregate handler for WindGenTurbineType3bIEC as outlined for the CQRS pattern, all write
 * responsibilities related to WindGenTurbineType3bIEC are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class WindGenTurbineType3bIECAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public WindGenTurbineType3bIECAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public WindGenTurbineType3bIECAggregate(CreateWindGenTurbineType3bIECCommand command)
      throws Exception {
    LOGGER.info("Handling command CreateWindGenTurbineType3bIECCommand");
    CreateWindGenTurbineType3bIECEvent event =
        new CreateWindGenTurbineType3bIECEvent(command.getWindGenTurbineType3bIECId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateWindGenTurbineType3bIECCommand command) throws Exception {
    LOGGER.info("handling command UpdateWindGenTurbineType3bIECCommand");
    UpdateWindGenTurbineType3bIECEvent event =
        new UpdateWindGenTurbineType3bIECEvent(
            command.getWindGenTurbineType3bIECId(),
            command.getFducw(),
            command.getMwtcwp(),
            command.getTg(),
            command.getTwo(),
            command.getXs());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteWindGenTurbineType3bIECCommand command) throws Exception {
    LOGGER.info("Handling command DeleteWindGenTurbineType3bIECCommand");
    apply(new DeleteWindGenTurbineType3bIECEvent(command.getWindGenTurbineType3bIECId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignFducwToWindGenTurbineType3bIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignFducwToWindGenTurbineType3bIECCommand");

    if (fducw != null && fducw.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Fducw already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignFducwToWindGenTurbineType3bIECEvent(
            command.getWindGenTurbineType3bIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignFducwFromWindGenTurbineType3bIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignFducwFromWindGenTurbineType3bIECCommand");

    if (fducw == null) throw new ProcessingException("Fducw already has nothing assigned.");

    apply(
        new UnAssignFducwFromWindGenTurbineType3bIECEvent(command.getWindGenTurbineType3bIECId()));
  }

  @CommandHandler
  public void handle(AssignMwtcwpToWindGenTurbineType3bIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignMwtcwpToWindGenTurbineType3bIECCommand");

    if (mwtcwp != null && mwtcwp.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Mwtcwp already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(
        new AssignMwtcwpToWindGenTurbineType3bIECEvent(
            command.getWindGenTurbineType3bIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMwtcwpFromWindGenTurbineType3bIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignMwtcwpFromWindGenTurbineType3bIECCommand");

    if (mwtcwp == null) throw new ProcessingException("Mwtcwp already has nothing assigned.");

    apply(
        new UnAssignMwtcwpFromWindGenTurbineType3bIECEvent(command.getWindGenTurbineType3bIECId()));
  }

  @CommandHandler
  public void handle(AssignTgToWindGenTurbineType3bIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignTgToWindGenTurbineType3bIECCommand");

    if (tg != null && tg.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tg already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTgToWindGenTurbineType3bIECEvent(
            command.getWindGenTurbineType3bIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTgFromWindGenTurbineType3bIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTgFromWindGenTurbineType3bIECCommand");

    if (tg == null) throw new ProcessingException("Tg already has nothing assigned.");

    apply(new UnAssignTgFromWindGenTurbineType3bIECEvent(command.getWindGenTurbineType3bIECId()));
  }

  @CommandHandler
  public void handle(AssignTwoToWindGenTurbineType3bIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignTwoToWindGenTurbineType3bIECCommand");

    if (two != null && two.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Two already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTwoToWindGenTurbineType3bIECEvent(
            command.getWindGenTurbineType3bIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTwoFromWindGenTurbineType3bIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTwoFromWindGenTurbineType3bIECCommand");

    if (two == null) throw new ProcessingException("Two already has nothing assigned.");

    apply(new UnAssignTwoFromWindGenTurbineType3bIECEvent(command.getWindGenTurbineType3bIECId()));
  }

  @CommandHandler
  public void handle(AssignXsToWindGenTurbineType3bIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignXsToWindGenTurbineType3bIECCommand");

    if (xs != null && xs.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Xs already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignXsToWindGenTurbineType3bIECEvent(
            command.getWindGenTurbineType3bIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignXsFromWindGenTurbineType3bIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignXsFromWindGenTurbineType3bIECCommand");

    if (xs == null) throw new ProcessingException("Xs already has nothing assigned.");

    apply(new UnAssignXsFromWindGenTurbineType3bIECEvent(command.getWindGenTurbineType3bIECId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateWindGenTurbineType3bIECEvent event) {
    LOGGER.info("Event sourcing CreateWindGenTurbineType3bIECEvent");
    this.windGenTurbineType3bIECId = event.getWindGenTurbineType3bIECId();
  }

  @EventSourcingHandler
  void on(UpdateWindGenTurbineType3bIECEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.fducw = event.getFducw();
    this.mwtcwp = event.getMwtcwp();
    this.tg = event.getTg();
    this.two = event.getTwo();
    this.xs = event.getXs();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignFducwToWindGenTurbineType3bIECEvent event) {
    LOGGER.info("Event sourcing AssignFducwToWindGenTurbineType3bIECEvent");
    this.fducw = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignFducwFromWindGenTurbineType3bIECEvent event) {
    LOGGER.info("Event sourcing UnAssignFducwFromWindGenTurbineType3bIECEvent");
    this.fducw = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMwtcwpToWindGenTurbineType3bIECEvent event) {
    LOGGER.info("Event sourcing AssignMwtcwpToWindGenTurbineType3bIECEvent");
    this.mwtcwp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMwtcwpFromWindGenTurbineType3bIECEvent event) {
    LOGGER.info("Event sourcing UnAssignMwtcwpFromWindGenTurbineType3bIECEvent");
    this.mwtcwp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTgToWindGenTurbineType3bIECEvent event) {
    LOGGER.info("Event sourcing AssignTgToWindGenTurbineType3bIECEvent");
    this.tg = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTgFromWindGenTurbineType3bIECEvent event) {
    LOGGER.info("Event sourcing UnAssignTgFromWindGenTurbineType3bIECEvent");
    this.tg = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTwoToWindGenTurbineType3bIECEvent event) {
    LOGGER.info("Event sourcing AssignTwoToWindGenTurbineType3bIECEvent");
    this.two = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTwoFromWindGenTurbineType3bIECEvent event) {
    LOGGER.info("Event sourcing UnAssignTwoFromWindGenTurbineType3bIECEvent");
    this.two = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignXsToWindGenTurbineType3bIECEvent event) {
    LOGGER.info("Event sourcing AssignXsToWindGenTurbineType3bIECEvent");
    this.xs = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignXsFromWindGenTurbineType3bIECEvent event) {
    LOGGER.info("Event sourcing UnAssignXsFromWindGenTurbineType3bIECEvent");
    this.xs = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID windGenTurbineType3bIECId;

  private Simple_Float fducw = null;
  private BooleanProxy mwtcwp = null;
  private Seconds tg = null;
  private Seconds two = null;
  private PU xs = null;

  private static final Logger LOGGER =
      Logger.getLogger(WindGenTurbineType3bIECAggregate.class.getName());
}
