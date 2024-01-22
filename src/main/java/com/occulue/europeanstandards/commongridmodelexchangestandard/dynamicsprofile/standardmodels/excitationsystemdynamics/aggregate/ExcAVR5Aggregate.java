package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.excitationsystemdynamics.aggregate;

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
 * Aggregate handler for ExcAVR5 as outlined for the CQRS pattern, all write responsibilities
 * related to ExcAVR5 are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ExcAVR5Aggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ExcAVR5Aggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ExcAVR5Aggregate(CreateExcAVR5Command command) throws Exception {
    LOGGER.info("Handling command CreateExcAVR5Command");
    CreateExcAVR5Event event = new CreateExcAVR5Event(command.getExcAVR5Id());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateExcAVR5Command command) throws Exception {
    LOGGER.info("handling command UpdateExcAVR5Command");
    UpdateExcAVR5Event event =
        new UpdateExcAVR5Event(
            command.getExcAVR5Id(), command.getKa(), command.getRex(), command.getTa());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteExcAVR5Command command) throws Exception {
    LOGGER.info("Handling command DeleteExcAVR5Command");
    apply(new DeleteExcAVR5Event(command.getExcAVR5Id()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignKaToExcAVR5Command command) throws Exception {
    LOGGER.info("Handling command AssignKaToExcAVR5Command");

    if (ka != null && ka.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ka already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKaToExcAVR5Event(command.getExcAVR5Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKaFromExcAVR5Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKaFromExcAVR5Command");

    if (ka == null) throw new ProcessingException("Ka already has nothing assigned.");

    apply(new UnAssignKaFromExcAVR5Event(command.getExcAVR5Id()));
  }

  @CommandHandler
  public void handle(AssignRexToExcAVR5Command command) throws Exception {
    LOGGER.info("Handling command AssignRexToExcAVR5Command");

    if (rex != null && rex.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Rex already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignRexToExcAVR5Event(command.getExcAVR5Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRexFromExcAVR5Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignRexFromExcAVR5Command");

    if (rex == null) throw new ProcessingException("Rex already has nothing assigned.");

    apply(new UnAssignRexFromExcAVR5Event(command.getExcAVR5Id()));
  }

  @CommandHandler
  public void handle(AssignTaToExcAVR5Command command) throws Exception {
    LOGGER.info("Handling command AssignTaToExcAVR5Command");

    if (ta != null && ta.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ta already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTaToExcAVR5Event(command.getExcAVR5Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTaFromExcAVR5Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTaFromExcAVR5Command");

    if (ta == null) throw new ProcessingException("Ta already has nothing assigned.");

    apply(new UnAssignTaFromExcAVR5Event(command.getExcAVR5Id()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateExcAVR5Event event) {
    LOGGER.info("Event sourcing CreateExcAVR5Event");
    this.excAVR5Id = event.getExcAVR5Id();
  }

  @EventSourcingHandler
  void on(UpdateExcAVR5Event event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.ka = event.getKa();
    this.rex = event.getRex();
    this.ta = event.getTa();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignKaToExcAVR5Event event) {
    LOGGER.info("Event sourcing AssignKaToExcAVR5Event");
    this.ka = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKaFromExcAVR5Event event) {
    LOGGER.info("Event sourcing UnAssignKaFromExcAVR5Event");
    this.ka = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRexToExcAVR5Event event) {
    LOGGER.info("Event sourcing AssignRexToExcAVR5Event");
    this.rex = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRexFromExcAVR5Event event) {
    LOGGER.info("Event sourcing UnAssignRexFromExcAVR5Event");
    this.rex = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTaToExcAVR5Event event) {
    LOGGER.info("Event sourcing AssignTaToExcAVR5Event");
    this.ta = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTaFromExcAVR5Event event) {
    LOGGER.info("Event sourcing UnAssignTaFromExcAVR5Event");
    this.ta = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID excAVR5Id;

  private PU ka = null;
  private PU rex = null;
  private Seconds ta = null;

  private static final Logger LOGGER = Logger.getLogger(ExcAVR5Aggregate.class.getName());
}
