package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.underexcitationlimiterdynamics.aggregate;

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
 * Aggregate handler for UnderexcLimX1 as outlined for the CQRS pattern, all write responsibilities
 * related to UnderexcLimX1 are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class UnderexcLimX1Aggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public UnderexcLimX1Aggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public UnderexcLimX1Aggregate(CreateUnderexcLimX1Command command) throws Exception {
    LOGGER.info("Handling command CreateUnderexcLimX1Command");
    CreateUnderexcLimX1Event event = new CreateUnderexcLimX1Event(command.getUnderexcLimX1Id());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateUnderexcLimX1Command command) throws Exception {
    LOGGER.info("handling command UpdateUnderexcLimX1Command");
    UpdateUnderexcLimX1Event event =
        new UpdateUnderexcLimX1Event(
            command.getUnderexcLimX1Id(),
            command.getK(),
            command.getKf2(),
            command.getKm(),
            command.getMelmax(),
            command.getTf2(),
            command.getTm());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteUnderexcLimX1Command command) throws Exception {
    LOGGER.info("Handling command DeleteUnderexcLimX1Command");
    apply(new DeleteUnderexcLimX1Event(command.getUnderexcLimX1Id()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignKToUnderexcLimX1Command command) throws Exception {
    LOGGER.info("Handling command AssignKToUnderexcLimX1Command");

    if (k != null && k.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "K already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKToUnderexcLimX1Event(command.getUnderexcLimX1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKFromUnderexcLimX1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKFromUnderexcLimX1Command");

    if (k == null) throw new ProcessingException("K already has nothing assigned.");

    apply(new UnAssignKFromUnderexcLimX1Event(command.getUnderexcLimX1Id()));
  }

  @CommandHandler
  public void handle(AssignKf2ToUnderexcLimX1Command command) throws Exception {
    LOGGER.info("Handling command AssignKf2ToUnderexcLimX1Command");

    if (kf2 != null && kf2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kf2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKf2ToUnderexcLimX1Event(command.getUnderexcLimX1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKf2FromUnderexcLimX1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKf2FromUnderexcLimX1Command");

    if (kf2 == null) throw new ProcessingException("Kf2 already has nothing assigned.");

    apply(new UnAssignKf2FromUnderexcLimX1Event(command.getUnderexcLimX1Id()));
  }

  @CommandHandler
  public void handle(AssignKmToUnderexcLimX1Command command) throws Exception {
    LOGGER.info("Handling command AssignKmToUnderexcLimX1Command");

    if (km != null && km.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Km already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKmToUnderexcLimX1Event(command.getUnderexcLimX1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKmFromUnderexcLimX1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKmFromUnderexcLimX1Command");

    if (km == null) throw new ProcessingException("Km already has nothing assigned.");

    apply(new UnAssignKmFromUnderexcLimX1Event(command.getUnderexcLimX1Id()));
  }

  @CommandHandler
  public void handle(AssignMelmaxToUnderexcLimX1Command command) throws Exception {
    LOGGER.info("Handling command AssignMelmaxToUnderexcLimX1Command");

    if (melmax != null && melmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Melmax already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignMelmaxToUnderexcLimX1Event(
            command.getUnderexcLimX1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMelmaxFromUnderexcLimX1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignMelmaxFromUnderexcLimX1Command");

    if (melmax == null) throw new ProcessingException("Melmax already has nothing assigned.");

    apply(new UnAssignMelmaxFromUnderexcLimX1Event(command.getUnderexcLimX1Id()));
  }

  @CommandHandler
  public void handle(AssignTf2ToUnderexcLimX1Command command) throws Exception {
    LOGGER.info("Handling command AssignTf2ToUnderexcLimX1Command");

    if (tf2 != null && tf2.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tf2 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTf2ToUnderexcLimX1Event(command.getUnderexcLimX1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTf2FromUnderexcLimX1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTf2FromUnderexcLimX1Command");

    if (tf2 == null) throw new ProcessingException("Tf2 already has nothing assigned.");

    apply(new UnAssignTf2FromUnderexcLimX1Event(command.getUnderexcLimX1Id()));
  }

  @CommandHandler
  public void handle(AssignTmToUnderexcLimX1Command command) throws Exception {
    LOGGER.info("Handling command AssignTmToUnderexcLimX1Command");

    if (tm != null && tm.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tm already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTmToUnderexcLimX1Event(command.getUnderexcLimX1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTmFromUnderexcLimX1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTmFromUnderexcLimX1Command");

    if (tm == null) throw new ProcessingException("Tm already has nothing assigned.");

    apply(new UnAssignTmFromUnderexcLimX1Event(command.getUnderexcLimX1Id()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateUnderexcLimX1Event event) {
    LOGGER.info("Event sourcing CreateUnderexcLimX1Event");
    this.underexcLimX1Id = event.getUnderexcLimX1Id();
  }

  @EventSourcingHandler
  void on(UpdateUnderexcLimX1Event event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.k = event.getK();
    this.kf2 = event.getKf2();
    this.km = event.getKm();
    this.melmax = event.getMelmax();
    this.tf2 = event.getTf2();
    this.tm = event.getTm();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignKToUnderexcLimX1Event event) {
    LOGGER.info("Event sourcing AssignKToUnderexcLimX1Event");
    this.k = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKFromUnderexcLimX1Event event) {
    LOGGER.info("Event sourcing UnAssignKFromUnderexcLimX1Event");
    this.k = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKf2ToUnderexcLimX1Event event) {
    LOGGER.info("Event sourcing AssignKf2ToUnderexcLimX1Event");
    this.kf2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKf2FromUnderexcLimX1Event event) {
    LOGGER.info("Event sourcing UnAssignKf2FromUnderexcLimX1Event");
    this.kf2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKmToUnderexcLimX1Event event) {
    LOGGER.info("Event sourcing AssignKmToUnderexcLimX1Event");
    this.km = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKmFromUnderexcLimX1Event event) {
    LOGGER.info("Event sourcing UnAssignKmFromUnderexcLimX1Event");
    this.km = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMelmaxToUnderexcLimX1Event event) {
    LOGGER.info("Event sourcing AssignMelmaxToUnderexcLimX1Event");
    this.melmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMelmaxFromUnderexcLimX1Event event) {
    LOGGER.info("Event sourcing UnAssignMelmaxFromUnderexcLimX1Event");
    this.melmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTf2ToUnderexcLimX1Event event) {
    LOGGER.info("Event sourcing AssignTf2ToUnderexcLimX1Event");
    this.tf2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTf2FromUnderexcLimX1Event event) {
    LOGGER.info("Event sourcing UnAssignTf2FromUnderexcLimX1Event");
    this.tf2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTmToUnderexcLimX1Event event) {
    LOGGER.info("Event sourcing AssignTmToUnderexcLimX1Event");
    this.tm = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTmFromUnderexcLimX1Event event) {
    LOGGER.info("Event sourcing UnAssignTmFromUnderexcLimX1Event");
    this.tm = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID underexcLimX1Id;

  private PU k = null;
  private PU kf2 = null;
  private PU km = null;
  private PU melmax = null;
  private Seconds tf2 = null;
  private Seconds tm = null;

  private static final Logger LOGGER = Logger.getLogger(UnderexcLimX1Aggregate.class.getName());
}
