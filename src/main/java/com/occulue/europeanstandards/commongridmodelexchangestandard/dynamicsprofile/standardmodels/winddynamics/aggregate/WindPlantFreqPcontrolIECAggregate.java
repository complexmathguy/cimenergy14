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
 * Aggregate handler for WindPlantFreqPcontrolIEC as outlined for the CQRS pattern, all write
 * responsibilities related to WindPlantFreqPcontrolIEC are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class WindPlantFreqPcontrolIECAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public WindPlantFreqPcontrolIECAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public WindPlantFreqPcontrolIECAggregate(CreateWindPlantFreqPcontrolIECCommand command)
      throws Exception {
    LOGGER.info("Handling command CreateWindPlantFreqPcontrolIECCommand");
    CreateWindPlantFreqPcontrolIECEvent event =
        new CreateWindPlantFreqPcontrolIECEvent(command.getWindPlantFreqPcontrolIECId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateWindPlantFreqPcontrolIECCommand command) throws Exception {
    LOGGER.info("handling command UpdateWindPlantFreqPcontrolIECCommand");
    UpdateWindPlantFreqPcontrolIECEvent event =
        new UpdateWindPlantFreqPcontrolIECEvent(
            command.getWindPlantFreqPcontrolIECId(),
            command.getDprefmax(),
            command.getDprefmin(),
            command.getKiwpp(),
            command.getKpwpp(),
            command.getPrefmax(),
            command.getPrefmin(),
            command.getTpft(),
            command.getTpfv(),
            command.getTwpffilt(),
            command.getTwppfilt());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteWindPlantFreqPcontrolIECCommand command) throws Exception {
    LOGGER.info("Handling command DeleteWindPlantFreqPcontrolIECCommand");
    apply(new DeleteWindPlantFreqPcontrolIECEvent(command.getWindPlantFreqPcontrolIECId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignDprefmaxToWindPlantFreqPcontrolIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignDprefmaxToWindPlantFreqPcontrolIECCommand");

    if (dprefmax != null && dprefmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Dprefmax already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignDprefmaxToWindPlantFreqPcontrolIECEvent(
            command.getWindPlantFreqPcontrolIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDprefmaxFromWindPlantFreqPcontrolIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignDprefmaxFromWindPlantFreqPcontrolIECCommand");

    if (dprefmax == null) throw new ProcessingException("Dprefmax already has nothing assigned.");

    apply(
        new UnAssignDprefmaxFromWindPlantFreqPcontrolIECEvent(
            command.getWindPlantFreqPcontrolIECId()));
  }

  @CommandHandler
  public void handle(AssignDprefminToWindPlantFreqPcontrolIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignDprefminToWindPlantFreqPcontrolIECCommand");

    if (dprefmin != null && dprefmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Dprefmin already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignDprefminToWindPlantFreqPcontrolIECEvent(
            command.getWindPlantFreqPcontrolIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDprefminFromWindPlantFreqPcontrolIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignDprefminFromWindPlantFreqPcontrolIECCommand");

    if (dprefmin == null) throw new ProcessingException("Dprefmin already has nothing assigned.");

    apply(
        new UnAssignDprefminFromWindPlantFreqPcontrolIECEvent(
            command.getWindPlantFreqPcontrolIECId()));
  }

  @CommandHandler
  public void handle(AssignKiwppToWindPlantFreqPcontrolIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignKiwppToWindPlantFreqPcontrolIECCommand");

    if (kiwpp != null && kiwpp.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Kiwpp already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignKiwppToWindPlantFreqPcontrolIECEvent(
            command.getWindPlantFreqPcontrolIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKiwppFromWindPlantFreqPcontrolIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKiwppFromWindPlantFreqPcontrolIECCommand");

    if (kiwpp == null) throw new ProcessingException("Kiwpp already has nothing assigned.");

    apply(
        new UnAssignKiwppFromWindPlantFreqPcontrolIECEvent(
            command.getWindPlantFreqPcontrolIECId()));
  }

  @CommandHandler
  public void handle(AssignKpwppToWindPlantFreqPcontrolIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignKpwppToWindPlantFreqPcontrolIECCommand");

    if (kpwpp != null && kpwpp.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Kpwpp already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignKpwppToWindPlantFreqPcontrolIECEvent(
            command.getWindPlantFreqPcontrolIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKpwppFromWindPlantFreqPcontrolIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKpwppFromWindPlantFreqPcontrolIECCommand");

    if (kpwpp == null) throw new ProcessingException("Kpwpp already has nothing assigned.");

    apply(
        new UnAssignKpwppFromWindPlantFreqPcontrolIECEvent(
            command.getWindPlantFreqPcontrolIECId()));
  }

  @CommandHandler
  public void handle(AssignPrefmaxToWindPlantFreqPcontrolIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignPrefmaxToWindPlantFreqPcontrolIECCommand");

    if (prefmax != null && prefmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Prefmax already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignPrefmaxToWindPlantFreqPcontrolIECEvent(
            command.getWindPlantFreqPcontrolIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPrefmaxFromWindPlantFreqPcontrolIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPrefmaxFromWindPlantFreqPcontrolIECCommand");

    if (prefmax == null) throw new ProcessingException("Prefmax already has nothing assigned.");

    apply(
        new UnAssignPrefmaxFromWindPlantFreqPcontrolIECEvent(
            command.getWindPlantFreqPcontrolIECId()));
  }

  @CommandHandler
  public void handle(AssignPrefminToWindPlantFreqPcontrolIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignPrefminToWindPlantFreqPcontrolIECCommand");

    if (prefmin != null && prefmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Prefmin already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignPrefminToWindPlantFreqPcontrolIECEvent(
            command.getWindPlantFreqPcontrolIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPrefminFromWindPlantFreqPcontrolIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPrefminFromWindPlantFreqPcontrolIECCommand");

    if (prefmin == null) throw new ProcessingException("Prefmin already has nothing assigned.");

    apply(
        new UnAssignPrefminFromWindPlantFreqPcontrolIECEvent(
            command.getWindPlantFreqPcontrolIECId()));
  }

  @CommandHandler
  public void handle(AssignTpftToWindPlantFreqPcontrolIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignTpftToWindPlantFreqPcontrolIECCommand");

    if (tpft != null && tpft.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tpft already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTpftToWindPlantFreqPcontrolIECEvent(
            command.getWindPlantFreqPcontrolIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTpftFromWindPlantFreqPcontrolIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTpftFromWindPlantFreqPcontrolIECCommand");

    if (tpft == null) throw new ProcessingException("Tpft already has nothing assigned.");

    apply(
        new UnAssignTpftFromWindPlantFreqPcontrolIECEvent(command.getWindPlantFreqPcontrolIECId()));
  }

  @CommandHandler
  public void handle(AssignTpfvToWindPlantFreqPcontrolIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignTpfvToWindPlantFreqPcontrolIECCommand");

    if (tpfv != null && tpfv.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tpfv already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTpfvToWindPlantFreqPcontrolIECEvent(
            command.getWindPlantFreqPcontrolIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTpfvFromWindPlantFreqPcontrolIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTpfvFromWindPlantFreqPcontrolIECCommand");

    if (tpfv == null) throw new ProcessingException("Tpfv already has nothing assigned.");

    apply(
        new UnAssignTpfvFromWindPlantFreqPcontrolIECEvent(command.getWindPlantFreqPcontrolIECId()));
  }

  @CommandHandler
  public void handle(AssignTwpffiltToWindPlantFreqPcontrolIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignTwpffiltToWindPlantFreqPcontrolIECCommand");

    if (twpffilt != null && twpffilt.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Twpffilt already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTwpffiltToWindPlantFreqPcontrolIECEvent(
            command.getWindPlantFreqPcontrolIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTwpffiltFromWindPlantFreqPcontrolIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTwpffiltFromWindPlantFreqPcontrolIECCommand");

    if (twpffilt == null) throw new ProcessingException("Twpffilt already has nothing assigned.");

    apply(
        new UnAssignTwpffiltFromWindPlantFreqPcontrolIECEvent(
            command.getWindPlantFreqPcontrolIECId()));
  }

  @CommandHandler
  public void handle(AssignTwppfiltToWindPlantFreqPcontrolIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignTwppfiltToWindPlantFreqPcontrolIECCommand");

    if (twppfilt != null && twppfilt.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Twppfilt already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTwppfiltToWindPlantFreqPcontrolIECEvent(
            command.getWindPlantFreqPcontrolIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTwppfiltFromWindPlantFreqPcontrolIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTwppfiltFromWindPlantFreqPcontrolIECCommand");

    if (twppfilt == null) throw new ProcessingException("Twppfilt already has nothing assigned.");

    apply(
        new UnAssignTwppfiltFromWindPlantFreqPcontrolIECEvent(
            command.getWindPlantFreqPcontrolIECId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateWindPlantFreqPcontrolIECEvent event) {
    LOGGER.info("Event sourcing CreateWindPlantFreqPcontrolIECEvent");
    this.windPlantFreqPcontrolIECId = event.getWindPlantFreqPcontrolIECId();
  }

  @EventSourcingHandler
  void on(UpdateWindPlantFreqPcontrolIECEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.dprefmax = event.getDprefmax();
    this.dprefmin = event.getDprefmin();
    this.kiwpp = event.getKiwpp();
    this.kpwpp = event.getKpwpp();
    this.prefmax = event.getPrefmax();
    this.prefmin = event.getPrefmin();
    this.tpft = event.getTpft();
    this.tpfv = event.getTpfv();
    this.twpffilt = event.getTwpffilt();
    this.twppfilt = event.getTwppfilt();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignDprefmaxToWindPlantFreqPcontrolIECEvent event) {
    LOGGER.info("Event sourcing AssignDprefmaxToWindPlantFreqPcontrolIECEvent");
    this.dprefmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDprefmaxFromWindPlantFreqPcontrolIECEvent event) {
    LOGGER.info("Event sourcing UnAssignDprefmaxFromWindPlantFreqPcontrolIECEvent");
    this.dprefmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDprefminToWindPlantFreqPcontrolIECEvent event) {
    LOGGER.info("Event sourcing AssignDprefminToWindPlantFreqPcontrolIECEvent");
    this.dprefmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDprefminFromWindPlantFreqPcontrolIECEvent event) {
    LOGGER.info("Event sourcing UnAssignDprefminFromWindPlantFreqPcontrolIECEvent");
    this.dprefmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKiwppToWindPlantFreqPcontrolIECEvent event) {
    LOGGER.info("Event sourcing AssignKiwppToWindPlantFreqPcontrolIECEvent");
    this.kiwpp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKiwppFromWindPlantFreqPcontrolIECEvent event) {
    LOGGER.info("Event sourcing UnAssignKiwppFromWindPlantFreqPcontrolIECEvent");
    this.kiwpp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKpwppToWindPlantFreqPcontrolIECEvent event) {
    LOGGER.info("Event sourcing AssignKpwppToWindPlantFreqPcontrolIECEvent");
    this.kpwpp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKpwppFromWindPlantFreqPcontrolIECEvent event) {
    LOGGER.info("Event sourcing UnAssignKpwppFromWindPlantFreqPcontrolIECEvent");
    this.kpwpp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPrefmaxToWindPlantFreqPcontrolIECEvent event) {
    LOGGER.info("Event sourcing AssignPrefmaxToWindPlantFreqPcontrolIECEvent");
    this.prefmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPrefmaxFromWindPlantFreqPcontrolIECEvent event) {
    LOGGER.info("Event sourcing UnAssignPrefmaxFromWindPlantFreqPcontrolIECEvent");
    this.prefmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPrefminToWindPlantFreqPcontrolIECEvent event) {
    LOGGER.info("Event sourcing AssignPrefminToWindPlantFreqPcontrolIECEvent");
    this.prefmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPrefminFromWindPlantFreqPcontrolIECEvent event) {
    LOGGER.info("Event sourcing UnAssignPrefminFromWindPlantFreqPcontrolIECEvent");
    this.prefmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTpftToWindPlantFreqPcontrolIECEvent event) {
    LOGGER.info("Event sourcing AssignTpftToWindPlantFreqPcontrolIECEvent");
    this.tpft = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTpftFromWindPlantFreqPcontrolIECEvent event) {
    LOGGER.info("Event sourcing UnAssignTpftFromWindPlantFreqPcontrolIECEvent");
    this.tpft = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTpfvToWindPlantFreqPcontrolIECEvent event) {
    LOGGER.info("Event sourcing AssignTpfvToWindPlantFreqPcontrolIECEvent");
    this.tpfv = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTpfvFromWindPlantFreqPcontrolIECEvent event) {
    LOGGER.info("Event sourcing UnAssignTpfvFromWindPlantFreqPcontrolIECEvent");
    this.tpfv = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTwpffiltToWindPlantFreqPcontrolIECEvent event) {
    LOGGER.info("Event sourcing AssignTwpffiltToWindPlantFreqPcontrolIECEvent");
    this.twpffilt = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTwpffiltFromWindPlantFreqPcontrolIECEvent event) {
    LOGGER.info("Event sourcing UnAssignTwpffiltFromWindPlantFreqPcontrolIECEvent");
    this.twpffilt = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTwppfiltToWindPlantFreqPcontrolIECEvent event) {
    LOGGER.info("Event sourcing AssignTwppfiltToWindPlantFreqPcontrolIECEvent");
    this.twppfilt = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTwppfiltFromWindPlantFreqPcontrolIECEvent event) {
    LOGGER.info("Event sourcing UnAssignTwppfiltFromWindPlantFreqPcontrolIECEvent");
    this.twppfilt = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID windPlantFreqPcontrolIECId;

  private PU dprefmax = null;
  private PU dprefmin = null;
  private Simple_Float kiwpp = null;
  private Simple_Float kpwpp = null;
  private PU prefmax = null;
  private PU prefmin = null;
  private Seconds tpft = null;
  private Seconds tpfv = null;
  private Seconds twpffilt = null;
  private Seconds twppfilt = null;

  private static final Logger LOGGER =
      Logger.getLogger(WindPlantFreqPcontrolIECAggregate.class.getName());
}
