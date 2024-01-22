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
 * Aggregate handler for WindContRotorRIEC as outlined for the CQRS pattern, all write
 * responsibilities related to WindContRotorRIEC are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class WindContRotorRIECAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public WindContRotorRIECAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public WindContRotorRIECAggregate(CreateWindContRotorRIECCommand command) throws Exception {
    LOGGER.info("Handling command CreateWindContRotorRIECCommand");
    CreateWindContRotorRIECEvent event =
        new CreateWindContRotorRIECEvent(command.getWindContRotorRIECId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateWindContRotorRIECCommand command) throws Exception {
    LOGGER.info("handling command UpdateWindContRotorRIECCommand");
    UpdateWindContRotorRIECEvent event =
        new UpdateWindContRotorRIECEvent(
            command.getWindContRotorRIECId(),
            command.getKirr(),
            command.getKomegafilt(),
            command.getKpfilt(),
            command.getKprr(),
            command.getRmax(),
            command.getRmin(),
            command.getTomegafilt(),
            command.getTpfilt());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteWindContRotorRIECCommand command) throws Exception {
    LOGGER.info("Handling command DeleteWindContRotorRIECCommand");
    apply(new DeleteWindContRotorRIECEvent(command.getWindContRotorRIECId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignKirrToWindContRotorRIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignKirrToWindContRotorRIECCommand");

    if (kirr != null && kirr.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kirr already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignKirrToWindContRotorRIECEvent(
            command.getWindContRotorRIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKirrFromWindContRotorRIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKirrFromWindContRotorRIECCommand");

    if (kirr == null) throw new ProcessingException("Kirr already has nothing assigned.");

    apply(new UnAssignKirrFromWindContRotorRIECEvent(command.getWindContRotorRIECId()));
  }

  @CommandHandler
  public void handle(AssignKomegafiltToWindContRotorRIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignKomegafiltToWindContRotorRIECCommand");

    if (komegafilt != null
        && komegafilt.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Komegafilt already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignKomegafiltToWindContRotorRIECEvent(
            command.getWindContRotorRIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKomegafiltFromWindContRotorRIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKomegafiltFromWindContRotorRIECCommand");

    if (komegafilt == null)
      throw new ProcessingException("Komegafilt already has nothing assigned.");

    apply(new UnAssignKomegafiltFromWindContRotorRIECEvent(command.getWindContRotorRIECId()));
  }

  @CommandHandler
  public void handle(AssignKpfiltToWindContRotorRIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignKpfiltToWindContRotorRIECCommand");

    if (kpfilt != null && kpfilt.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Kpfilt already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignKpfiltToWindContRotorRIECEvent(
            command.getWindContRotorRIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKpfiltFromWindContRotorRIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKpfiltFromWindContRotorRIECCommand");

    if (kpfilt == null) throw new ProcessingException("Kpfilt already has nothing assigned.");

    apply(new UnAssignKpfiltFromWindContRotorRIECEvent(command.getWindContRotorRIECId()));
  }

  @CommandHandler
  public void handle(AssignKprrToWindContRotorRIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignKprrToWindContRotorRIECCommand");

    if (kprr != null && kprr.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kprr already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignKprrToWindContRotorRIECEvent(
            command.getWindContRotorRIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKprrFromWindContRotorRIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKprrFromWindContRotorRIECCommand");

    if (kprr == null) throw new ProcessingException("Kprr already has nothing assigned.");

    apply(new UnAssignKprrFromWindContRotorRIECEvent(command.getWindContRotorRIECId()));
  }

  @CommandHandler
  public void handle(AssignRmaxToWindContRotorRIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignRmaxToWindContRotorRIECCommand");

    if (rmax != null && rmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Rmax already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignRmaxToWindContRotorRIECEvent(
            command.getWindContRotorRIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRmaxFromWindContRotorRIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignRmaxFromWindContRotorRIECCommand");

    if (rmax == null) throw new ProcessingException("Rmax already has nothing assigned.");

    apply(new UnAssignRmaxFromWindContRotorRIECEvent(command.getWindContRotorRIECId()));
  }

  @CommandHandler
  public void handle(AssignRminToWindContRotorRIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignRminToWindContRotorRIECCommand");

    if (rmin != null && rmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Rmin already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignRminToWindContRotorRIECEvent(
            command.getWindContRotorRIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRminFromWindContRotorRIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignRminFromWindContRotorRIECCommand");

    if (rmin == null) throw new ProcessingException("Rmin already has nothing assigned.");

    apply(new UnAssignRminFromWindContRotorRIECEvent(command.getWindContRotorRIECId()));
  }

  @CommandHandler
  public void handle(AssignTomegafiltToWindContRotorRIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignTomegafiltToWindContRotorRIECCommand");

    if (tomegafilt != null && tomegafilt.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tomegafilt already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTomegafiltToWindContRotorRIECEvent(
            command.getWindContRotorRIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTomegafiltFromWindContRotorRIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTomegafiltFromWindContRotorRIECCommand");

    if (tomegafilt == null)
      throw new ProcessingException("Tomegafilt already has nothing assigned.");

    apply(new UnAssignTomegafiltFromWindContRotorRIECEvent(command.getWindContRotorRIECId()));
  }

  @CommandHandler
  public void handle(AssignTpfiltToWindContRotorRIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignTpfiltToWindContRotorRIECCommand");

    if (tpfilt != null && tpfilt.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tpfilt already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTpfiltToWindContRotorRIECEvent(
            command.getWindContRotorRIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTpfiltFromWindContRotorRIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTpfiltFromWindContRotorRIECCommand");

    if (tpfilt == null) throw new ProcessingException("Tpfilt already has nothing assigned.");

    apply(new UnAssignTpfiltFromWindContRotorRIECEvent(command.getWindContRotorRIECId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateWindContRotorRIECEvent event) {
    LOGGER.info("Event sourcing CreateWindContRotorRIECEvent");
    this.windContRotorRIECId = event.getWindContRotorRIECId();
  }

  @EventSourcingHandler
  void on(UpdateWindContRotorRIECEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.kirr = event.getKirr();
    this.komegafilt = event.getKomegafilt();
    this.kpfilt = event.getKpfilt();
    this.kprr = event.getKprr();
    this.rmax = event.getRmax();
    this.rmin = event.getRmin();
    this.tomegafilt = event.getTomegafilt();
    this.tpfilt = event.getTpfilt();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignKirrToWindContRotorRIECEvent event) {
    LOGGER.info("Event sourcing AssignKirrToWindContRotorRIECEvent");
    this.kirr = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKirrFromWindContRotorRIECEvent event) {
    LOGGER.info("Event sourcing UnAssignKirrFromWindContRotorRIECEvent");
    this.kirr = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKomegafiltToWindContRotorRIECEvent event) {
    LOGGER.info("Event sourcing AssignKomegafiltToWindContRotorRIECEvent");
    this.komegafilt = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKomegafiltFromWindContRotorRIECEvent event) {
    LOGGER.info("Event sourcing UnAssignKomegafiltFromWindContRotorRIECEvent");
    this.komegafilt = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKpfiltToWindContRotorRIECEvent event) {
    LOGGER.info("Event sourcing AssignKpfiltToWindContRotorRIECEvent");
    this.kpfilt = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKpfiltFromWindContRotorRIECEvent event) {
    LOGGER.info("Event sourcing UnAssignKpfiltFromWindContRotorRIECEvent");
    this.kpfilt = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKprrToWindContRotorRIECEvent event) {
    LOGGER.info("Event sourcing AssignKprrToWindContRotorRIECEvent");
    this.kprr = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKprrFromWindContRotorRIECEvent event) {
    LOGGER.info("Event sourcing UnAssignKprrFromWindContRotorRIECEvent");
    this.kprr = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRmaxToWindContRotorRIECEvent event) {
    LOGGER.info("Event sourcing AssignRmaxToWindContRotorRIECEvent");
    this.rmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRmaxFromWindContRotorRIECEvent event) {
    LOGGER.info("Event sourcing UnAssignRmaxFromWindContRotorRIECEvent");
    this.rmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRminToWindContRotorRIECEvent event) {
    LOGGER.info("Event sourcing AssignRminToWindContRotorRIECEvent");
    this.rmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRminFromWindContRotorRIECEvent event) {
    LOGGER.info("Event sourcing UnAssignRminFromWindContRotorRIECEvent");
    this.rmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTomegafiltToWindContRotorRIECEvent event) {
    LOGGER.info("Event sourcing AssignTomegafiltToWindContRotorRIECEvent");
    this.tomegafilt = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTomegafiltFromWindContRotorRIECEvent event) {
    LOGGER.info("Event sourcing UnAssignTomegafiltFromWindContRotorRIECEvent");
    this.tomegafilt = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTpfiltToWindContRotorRIECEvent event) {
    LOGGER.info("Event sourcing AssignTpfiltToWindContRotorRIECEvent");
    this.tpfilt = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTpfiltFromWindContRotorRIECEvent event) {
    LOGGER.info("Event sourcing UnAssignTpfiltFromWindContRotorRIECEvent");
    this.tpfilt = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID windContRotorRIECId;

  private PU kirr = null;
  private Simple_Float komegafilt = null;
  private Simple_Float kpfilt = null;
  private PU kprr = null;
  private PU rmax = null;
  private PU rmin = null;
  private Seconds tomegafilt = null;
  private Seconds tpfilt = null;

  private static final Logger LOGGER = Logger.getLogger(WindContRotorRIECAggregate.class.getName());
}
