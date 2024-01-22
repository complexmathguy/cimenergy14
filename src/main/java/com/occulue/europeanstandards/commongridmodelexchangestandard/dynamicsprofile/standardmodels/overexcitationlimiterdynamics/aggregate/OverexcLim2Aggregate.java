package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.overexcitationlimiterdynamics.aggregate;

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
 * Aggregate handler for OverexcLim2 as outlined for the CQRS pattern, all write responsibilities
 * related to OverexcLim2 are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class OverexcLim2Aggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public OverexcLim2Aggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public OverexcLim2Aggregate(CreateOverexcLim2Command command) throws Exception {
    LOGGER.info("Handling command CreateOverexcLim2Command");
    CreateOverexcLim2Event event = new CreateOverexcLim2Event(command.getOverexcLim2Id());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateOverexcLim2Command command) throws Exception {
    LOGGER.info("handling command UpdateOverexcLim2Command");
    UpdateOverexcLim2Event event =
        new UpdateOverexcLim2Event(
            command.getOverexcLim2Id(),
            command.getIfdlim(),
            command.getKoi(),
            command.getVoimax(),
            command.getVoimin());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteOverexcLim2Command command) throws Exception {
    LOGGER.info("Handling command DeleteOverexcLim2Command");
    apply(new DeleteOverexcLim2Event(command.getOverexcLim2Id()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignIfdlimToOverexcLim2Command command) throws Exception {
    LOGGER.info("Handling command AssignIfdlimToOverexcLim2Command");

    if (ifdlim != null && ifdlim.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ifdlim already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignIfdlimToOverexcLim2Event(command.getOverexcLim2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignIfdlimFromOverexcLim2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignIfdlimFromOverexcLim2Command");

    if (ifdlim == null) throw new ProcessingException("Ifdlim already has nothing assigned.");

    apply(new UnAssignIfdlimFromOverexcLim2Event(command.getOverexcLim2Id()));
  }

  @CommandHandler
  public void handle(AssignKoiToOverexcLim2Command command) throws Exception {
    LOGGER.info("Handling command AssignKoiToOverexcLim2Command");

    if (koi != null && koi.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Koi already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKoiToOverexcLim2Event(command.getOverexcLim2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKoiFromOverexcLim2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKoiFromOverexcLim2Command");

    if (koi == null) throw new ProcessingException("Koi already has nothing assigned.");

    apply(new UnAssignKoiFromOverexcLim2Event(command.getOverexcLim2Id()));
  }

  @CommandHandler
  public void handle(AssignVoimaxToOverexcLim2Command command) throws Exception {
    LOGGER.info("Handling command AssignVoimaxToOverexcLim2Command");

    if (voimax != null && voimax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Voimax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVoimaxToOverexcLim2Event(command.getOverexcLim2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVoimaxFromOverexcLim2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignVoimaxFromOverexcLim2Command");

    if (voimax == null) throw new ProcessingException("Voimax already has nothing assigned.");

    apply(new UnAssignVoimaxFromOverexcLim2Event(command.getOverexcLim2Id()));
  }

  @CommandHandler
  public void handle(AssignVoiminToOverexcLim2Command command) throws Exception {
    LOGGER.info("Handling command AssignVoiminToOverexcLim2Command");

    if (voimin != null && voimin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Voimin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVoiminToOverexcLim2Event(command.getOverexcLim2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVoiminFromOverexcLim2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignVoiminFromOverexcLim2Command");

    if (voimin == null) throw new ProcessingException("Voimin already has nothing assigned.");

    apply(new UnAssignVoiminFromOverexcLim2Event(command.getOverexcLim2Id()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateOverexcLim2Event event) {
    LOGGER.info("Event sourcing CreateOverexcLim2Event");
    this.overexcLim2Id = event.getOverexcLim2Id();
  }

  @EventSourcingHandler
  void on(UpdateOverexcLim2Event event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.ifdlim = event.getIfdlim();
    this.koi = event.getKoi();
    this.voimax = event.getVoimax();
    this.voimin = event.getVoimin();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignIfdlimToOverexcLim2Event event) {
    LOGGER.info("Event sourcing AssignIfdlimToOverexcLim2Event");
    this.ifdlim = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignIfdlimFromOverexcLim2Event event) {
    LOGGER.info("Event sourcing UnAssignIfdlimFromOverexcLim2Event");
    this.ifdlim = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKoiToOverexcLim2Event event) {
    LOGGER.info("Event sourcing AssignKoiToOverexcLim2Event");
    this.koi = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKoiFromOverexcLim2Event event) {
    LOGGER.info("Event sourcing UnAssignKoiFromOverexcLim2Event");
    this.koi = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVoimaxToOverexcLim2Event event) {
    LOGGER.info("Event sourcing AssignVoimaxToOverexcLim2Event");
    this.voimax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVoimaxFromOverexcLim2Event event) {
    LOGGER.info("Event sourcing UnAssignVoimaxFromOverexcLim2Event");
    this.voimax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVoiminToOverexcLim2Event event) {
    LOGGER.info("Event sourcing AssignVoiminToOverexcLim2Event");
    this.voimin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVoiminFromOverexcLim2Event event) {
    LOGGER.info("Event sourcing UnAssignVoiminFromOverexcLim2Event");
    this.voimin = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID overexcLim2Id;

  private PU ifdlim = null;
  private PU koi = null;
  private PU voimax = null;
  private PU voimin = null;

  private static final Logger LOGGER = Logger.getLogger(OverexcLim2Aggregate.class.getName());
}
