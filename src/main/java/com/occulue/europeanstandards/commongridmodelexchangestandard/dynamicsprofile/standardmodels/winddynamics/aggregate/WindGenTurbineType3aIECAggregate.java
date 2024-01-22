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
 * Aggregate handler for WindGenTurbineType3aIEC as outlined for the CQRS pattern, all write
 * responsibilities related to WindGenTurbineType3aIEC are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class WindGenTurbineType3aIECAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public WindGenTurbineType3aIECAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public WindGenTurbineType3aIECAggregate(CreateWindGenTurbineType3aIECCommand command)
      throws Exception {
    LOGGER.info("Handling command CreateWindGenTurbineType3aIECCommand");
    CreateWindGenTurbineType3aIECEvent event =
        new CreateWindGenTurbineType3aIECEvent(command.getWindGenTurbineType3aIECId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateWindGenTurbineType3aIECCommand command) throws Exception {
    LOGGER.info("handling command UpdateWindGenTurbineType3aIECCommand");
    UpdateWindGenTurbineType3aIECEvent event =
        new UpdateWindGenTurbineType3aIECEvent(
            command.getWindGenTurbineType3aIECId(),
            command.getKpc(),
            command.getTic(),
            command.getXs());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteWindGenTurbineType3aIECCommand command) throws Exception {
    LOGGER.info("Handling command DeleteWindGenTurbineType3aIECCommand");
    apply(new DeleteWindGenTurbineType3aIECEvent(command.getWindGenTurbineType3aIECId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignKpcToWindGenTurbineType3aIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignKpcToWindGenTurbineType3aIECCommand");

    if (kpc != null && kpc.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Kpc already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignKpcToWindGenTurbineType3aIECEvent(
            command.getWindGenTurbineType3aIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKpcFromWindGenTurbineType3aIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKpcFromWindGenTurbineType3aIECCommand");

    if (kpc == null) throw new ProcessingException("Kpc already has nothing assigned.");

    apply(new UnAssignKpcFromWindGenTurbineType3aIECEvent(command.getWindGenTurbineType3aIECId()));
  }

  @CommandHandler
  public void handle(AssignTicToWindGenTurbineType3aIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignTicToWindGenTurbineType3aIECCommand");

    if (tic != null && tic.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tic already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTicToWindGenTurbineType3aIECEvent(
            command.getWindGenTurbineType3aIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTicFromWindGenTurbineType3aIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTicFromWindGenTurbineType3aIECCommand");

    if (tic == null) throw new ProcessingException("Tic already has nothing assigned.");

    apply(new UnAssignTicFromWindGenTurbineType3aIECEvent(command.getWindGenTurbineType3aIECId()));
  }

  @CommandHandler
  public void handle(AssignXsToWindGenTurbineType3aIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignXsToWindGenTurbineType3aIECCommand");

    if (xs != null && xs.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Xs already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignXsToWindGenTurbineType3aIECEvent(
            command.getWindGenTurbineType3aIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignXsFromWindGenTurbineType3aIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignXsFromWindGenTurbineType3aIECCommand");

    if (xs == null) throw new ProcessingException("Xs already has nothing assigned.");

    apply(new UnAssignXsFromWindGenTurbineType3aIECEvent(command.getWindGenTurbineType3aIECId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateWindGenTurbineType3aIECEvent event) {
    LOGGER.info("Event sourcing CreateWindGenTurbineType3aIECEvent");
    this.windGenTurbineType3aIECId = event.getWindGenTurbineType3aIECId();
  }

  @EventSourcingHandler
  void on(UpdateWindGenTurbineType3aIECEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.kpc = event.getKpc();
    this.tic = event.getTic();
    this.xs = event.getXs();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignKpcToWindGenTurbineType3aIECEvent event) {
    LOGGER.info("Event sourcing AssignKpcToWindGenTurbineType3aIECEvent");
    this.kpc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKpcFromWindGenTurbineType3aIECEvent event) {
    LOGGER.info("Event sourcing UnAssignKpcFromWindGenTurbineType3aIECEvent");
    this.kpc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTicToWindGenTurbineType3aIECEvent event) {
    LOGGER.info("Event sourcing AssignTicToWindGenTurbineType3aIECEvent");
    this.tic = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTicFromWindGenTurbineType3aIECEvent event) {
    LOGGER.info("Event sourcing UnAssignTicFromWindGenTurbineType3aIECEvent");
    this.tic = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignXsToWindGenTurbineType3aIECEvent event) {
    LOGGER.info("Event sourcing AssignXsToWindGenTurbineType3aIECEvent");
    this.xs = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignXsFromWindGenTurbineType3aIECEvent event) {
    LOGGER.info("Event sourcing UnAssignXsFromWindGenTurbineType3aIECEvent");
    this.xs = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID windGenTurbineType3aIECId;

  private Simple_Float kpc = null;
  private Seconds tic = null;
  private PU xs = null;

  private static final Logger LOGGER =
      Logger.getLogger(WindGenTurbineType3aIECAggregate.class.getName());
}
