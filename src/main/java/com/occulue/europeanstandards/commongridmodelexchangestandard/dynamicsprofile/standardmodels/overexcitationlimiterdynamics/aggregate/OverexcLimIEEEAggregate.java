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
 * Aggregate handler for OverexcLimIEEE as outlined for the CQRS pattern, all write responsibilities
 * related to OverexcLimIEEE are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class OverexcLimIEEEAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public OverexcLimIEEEAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public OverexcLimIEEEAggregate(CreateOverexcLimIEEECommand command) throws Exception {
    LOGGER.info("Handling command CreateOverexcLimIEEECommand");
    CreateOverexcLimIEEEEvent event = new CreateOverexcLimIEEEEvent(command.getOverexcLimIEEEId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateOverexcLimIEEECommand command) throws Exception {
    LOGGER.info("handling command UpdateOverexcLimIEEECommand");
    UpdateOverexcLimIEEEEvent event =
        new UpdateOverexcLimIEEEEvent(
            command.getOverexcLimIEEEId(),
            command.getHyst(),
            command.getIfdlim(),
            command.getIfdmax(),
            command.getItfpu(),
            command.getKcd(),
            command.getKramp());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteOverexcLimIEEECommand command) throws Exception {
    LOGGER.info("Handling command DeleteOverexcLimIEEECommand");
    apply(new DeleteOverexcLimIEEEEvent(command.getOverexcLimIEEEId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignHystToOverexcLimIEEECommand command) throws Exception {
    LOGGER.info("Handling command AssignHystToOverexcLimIEEECommand");

    if (hyst != null && hyst.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Hyst already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignHystToOverexcLimIEEEEvent(
            command.getOverexcLimIEEEId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignHystFromOverexcLimIEEECommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignHystFromOverexcLimIEEECommand");

    if (hyst == null) throw new ProcessingException("Hyst already has nothing assigned.");

    apply(new UnAssignHystFromOverexcLimIEEEEvent(command.getOverexcLimIEEEId()));
  }

  @CommandHandler
  public void handle(AssignIfdlimToOverexcLimIEEECommand command) throws Exception {
    LOGGER.info("Handling command AssignIfdlimToOverexcLimIEEECommand");

    if (ifdlim != null && ifdlim.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ifdlim already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignIfdlimToOverexcLimIEEEEvent(
            command.getOverexcLimIEEEId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignIfdlimFromOverexcLimIEEECommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignIfdlimFromOverexcLimIEEECommand");

    if (ifdlim == null) throw new ProcessingException("Ifdlim already has nothing assigned.");

    apply(new UnAssignIfdlimFromOverexcLimIEEEEvent(command.getOverexcLimIEEEId()));
  }

  @CommandHandler
  public void handle(AssignIfdmaxToOverexcLimIEEECommand command) throws Exception {
    LOGGER.info("Handling command AssignIfdmaxToOverexcLimIEEECommand");

    if (ifdmax != null && ifdmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ifdmax already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignIfdmaxToOverexcLimIEEEEvent(
            command.getOverexcLimIEEEId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignIfdmaxFromOverexcLimIEEECommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignIfdmaxFromOverexcLimIEEECommand");

    if (ifdmax == null) throw new ProcessingException("Ifdmax already has nothing assigned.");

    apply(new UnAssignIfdmaxFromOverexcLimIEEEEvent(command.getOverexcLimIEEEId()));
  }

  @CommandHandler
  public void handle(AssignItfpuToOverexcLimIEEECommand command) throws Exception {
    LOGGER.info("Handling command AssignItfpuToOverexcLimIEEECommand");

    if (itfpu != null && itfpu.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Itfpu already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignItfpuToOverexcLimIEEEEvent(
            command.getOverexcLimIEEEId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignItfpuFromOverexcLimIEEECommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignItfpuFromOverexcLimIEEECommand");

    if (itfpu == null) throw new ProcessingException("Itfpu already has nothing assigned.");

    apply(new UnAssignItfpuFromOverexcLimIEEEEvent(command.getOverexcLimIEEEId()));
  }

  @CommandHandler
  public void handle(AssignKcdToOverexcLimIEEECommand command) throws Exception {
    LOGGER.info("Handling command AssignKcdToOverexcLimIEEECommand");

    if (kcd != null && kcd.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kcd already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignKcdToOverexcLimIEEEEvent(command.getOverexcLimIEEEId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKcdFromOverexcLimIEEECommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKcdFromOverexcLimIEEECommand");

    if (kcd == null) throw new ProcessingException("Kcd already has nothing assigned.");

    apply(new UnAssignKcdFromOverexcLimIEEEEvent(command.getOverexcLimIEEEId()));
  }

  @CommandHandler
  public void handle(AssignKrampToOverexcLimIEEECommand command) throws Exception {
    LOGGER.info("Handling command AssignKrampToOverexcLimIEEECommand");

    if (kramp != null && kramp.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Kramp already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignKrampToOverexcLimIEEEEvent(
            command.getOverexcLimIEEEId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKrampFromOverexcLimIEEECommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKrampFromOverexcLimIEEECommand");

    if (kramp == null) throw new ProcessingException("Kramp already has nothing assigned.");

    apply(new UnAssignKrampFromOverexcLimIEEEEvent(command.getOverexcLimIEEEId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateOverexcLimIEEEEvent event) {
    LOGGER.info("Event sourcing CreateOverexcLimIEEEEvent");
    this.overexcLimIEEEId = event.getOverexcLimIEEEId();
  }

  @EventSourcingHandler
  void on(UpdateOverexcLimIEEEEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.hyst = event.getHyst();
    this.ifdlim = event.getIfdlim();
    this.ifdmax = event.getIfdmax();
    this.itfpu = event.getItfpu();
    this.kcd = event.getKcd();
    this.kramp = event.getKramp();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignHystToOverexcLimIEEEEvent event) {
    LOGGER.info("Event sourcing AssignHystToOverexcLimIEEEEvent");
    this.hyst = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignHystFromOverexcLimIEEEEvent event) {
    LOGGER.info("Event sourcing UnAssignHystFromOverexcLimIEEEEvent");
    this.hyst = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignIfdlimToOverexcLimIEEEEvent event) {
    LOGGER.info("Event sourcing AssignIfdlimToOverexcLimIEEEEvent");
    this.ifdlim = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignIfdlimFromOverexcLimIEEEEvent event) {
    LOGGER.info("Event sourcing UnAssignIfdlimFromOverexcLimIEEEEvent");
    this.ifdlim = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignIfdmaxToOverexcLimIEEEEvent event) {
    LOGGER.info("Event sourcing AssignIfdmaxToOverexcLimIEEEEvent");
    this.ifdmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignIfdmaxFromOverexcLimIEEEEvent event) {
    LOGGER.info("Event sourcing UnAssignIfdmaxFromOverexcLimIEEEEvent");
    this.ifdmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignItfpuToOverexcLimIEEEEvent event) {
    LOGGER.info("Event sourcing AssignItfpuToOverexcLimIEEEEvent");
    this.itfpu = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignItfpuFromOverexcLimIEEEEvent event) {
    LOGGER.info("Event sourcing UnAssignItfpuFromOverexcLimIEEEEvent");
    this.itfpu = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKcdToOverexcLimIEEEEvent event) {
    LOGGER.info("Event sourcing AssignKcdToOverexcLimIEEEEvent");
    this.kcd = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKcdFromOverexcLimIEEEEvent event) {
    LOGGER.info("Event sourcing UnAssignKcdFromOverexcLimIEEEEvent");
    this.kcd = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKrampToOverexcLimIEEEEvent event) {
    LOGGER.info("Event sourcing AssignKrampToOverexcLimIEEEEvent");
    this.kramp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKrampFromOverexcLimIEEEEvent event) {
    LOGGER.info("Event sourcing UnAssignKrampFromOverexcLimIEEEEvent");
    this.kramp = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID overexcLimIEEEId;

  private PU hyst = null;
  private PU ifdlim = null;
  private PU ifdmax = null;
  private PU itfpu = null;
  private PU kcd = null;
  private Simple_Float kramp = null;

  private static final Logger LOGGER = Logger.getLogger(OverexcLimIEEEAggregate.class.getName());
}
