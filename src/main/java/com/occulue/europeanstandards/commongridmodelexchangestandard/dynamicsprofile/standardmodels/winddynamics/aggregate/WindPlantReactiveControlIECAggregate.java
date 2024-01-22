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
 * Aggregate handler for WindPlantReactiveControlIEC as outlined for the CQRS pattern, all write
 * responsibilities related to WindPlantReactiveControlIEC are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class WindPlantReactiveControlIECAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public WindPlantReactiveControlIECAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public WindPlantReactiveControlIECAggregate(CreateWindPlantReactiveControlIECCommand command)
      throws Exception {
    LOGGER.info("Handling command CreateWindPlantReactiveControlIECCommand");
    CreateWindPlantReactiveControlIECEvent event =
        new CreateWindPlantReactiveControlIECEvent(command.getWindPlantReactiveControlIECId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateWindPlantReactiveControlIECCommand command) throws Exception {
    LOGGER.info("handling command UpdateWindPlantReactiveControlIECCommand");
    UpdateWindPlantReactiveControlIECEvent event =
        new UpdateWindPlantReactiveControlIECEvent(
            command.getWindPlantReactiveControlIECId(),
            command.getKiwpx(),
            command.getKpwpx(),
            command.getKwpqu(),
            command.getMwppf(),
            command.getMwpu(),
            command.getTwppfilt(),
            command.getTwpqfilt(),
            command.getTwpufilt(),
            command.getTxft(),
            command.getTxfv(),
            command.getUwpqdip(),
            command.getXrefmax(),
            command.getXrefmin());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteWindPlantReactiveControlIECCommand command) throws Exception {
    LOGGER.info("Handling command DeleteWindPlantReactiveControlIECCommand");
    apply(new DeleteWindPlantReactiveControlIECEvent(command.getWindPlantReactiveControlIECId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignKiwpxToWindPlantReactiveControlIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignKiwpxToWindPlantReactiveControlIECCommand");

    if (kiwpx != null && kiwpx.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Kiwpx already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignKiwpxToWindPlantReactiveControlIECEvent(
            command.getWindPlantReactiveControlIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKiwpxFromWindPlantReactiveControlIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKiwpxFromWindPlantReactiveControlIECCommand");

    if (kiwpx == null) throw new ProcessingException("Kiwpx already has nothing assigned.");

    apply(
        new UnAssignKiwpxFromWindPlantReactiveControlIECEvent(
            command.getWindPlantReactiveControlIECId()));
  }

  @CommandHandler
  public void handle(AssignKpwpxToWindPlantReactiveControlIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignKpwpxToWindPlantReactiveControlIECCommand");

    if (kpwpx != null && kpwpx.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Kpwpx already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignKpwpxToWindPlantReactiveControlIECEvent(
            command.getWindPlantReactiveControlIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKpwpxFromWindPlantReactiveControlIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKpwpxFromWindPlantReactiveControlIECCommand");

    if (kpwpx == null) throw new ProcessingException("Kpwpx already has nothing assigned.");

    apply(
        new UnAssignKpwpxFromWindPlantReactiveControlIECEvent(
            command.getWindPlantReactiveControlIECId()));
  }

  @CommandHandler
  public void handle(AssignKwpquToWindPlantReactiveControlIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignKwpquToWindPlantReactiveControlIECCommand");

    if (kwpqu != null && kwpqu.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kwpqu already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignKwpquToWindPlantReactiveControlIECEvent(
            command.getWindPlantReactiveControlIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKwpquFromWindPlantReactiveControlIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKwpquFromWindPlantReactiveControlIECCommand");

    if (kwpqu == null) throw new ProcessingException("Kwpqu already has nothing assigned.");

    apply(
        new UnAssignKwpquFromWindPlantReactiveControlIECEvent(
            command.getWindPlantReactiveControlIECId()));
  }

  @CommandHandler
  public void handle(AssignMwppfToWindPlantReactiveControlIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignMwppfToWindPlantReactiveControlIECCommand");

    if (mwppf != null && mwppf.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Mwppf already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(
        new AssignMwppfToWindPlantReactiveControlIECEvent(
            command.getWindPlantReactiveControlIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMwppfFromWindPlantReactiveControlIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignMwppfFromWindPlantReactiveControlIECCommand");

    if (mwppf == null) throw new ProcessingException("Mwppf already has nothing assigned.");

    apply(
        new UnAssignMwppfFromWindPlantReactiveControlIECEvent(
            command.getWindPlantReactiveControlIECId()));
  }

  @CommandHandler
  public void handle(AssignMwpuToWindPlantReactiveControlIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignMwpuToWindPlantReactiveControlIECCommand");

    if (mwpu != null && mwpu.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Mwpu already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(
        new AssignMwpuToWindPlantReactiveControlIECEvent(
            command.getWindPlantReactiveControlIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMwpuFromWindPlantReactiveControlIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignMwpuFromWindPlantReactiveControlIECCommand");

    if (mwpu == null) throw new ProcessingException("Mwpu already has nothing assigned.");

    apply(
        new UnAssignMwpuFromWindPlantReactiveControlIECEvent(
            command.getWindPlantReactiveControlIECId()));
  }

  @CommandHandler
  public void handle(AssignTwppfiltToWindPlantReactiveControlIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignTwppfiltToWindPlantReactiveControlIECCommand");

    if (twppfilt != null && twppfilt.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Twppfilt already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTwppfiltToWindPlantReactiveControlIECEvent(
            command.getWindPlantReactiveControlIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTwppfiltFromWindPlantReactiveControlIECCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignTwppfiltFromWindPlantReactiveControlIECCommand");

    if (twppfilt == null) throw new ProcessingException("Twppfilt already has nothing assigned.");

    apply(
        new UnAssignTwppfiltFromWindPlantReactiveControlIECEvent(
            command.getWindPlantReactiveControlIECId()));
  }

  @CommandHandler
  public void handle(AssignTwpqfiltToWindPlantReactiveControlIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignTwpqfiltToWindPlantReactiveControlIECCommand");

    if (twpqfilt != null && twpqfilt.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Twpqfilt already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTwpqfiltToWindPlantReactiveControlIECEvent(
            command.getWindPlantReactiveControlIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTwpqfiltFromWindPlantReactiveControlIECCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignTwpqfiltFromWindPlantReactiveControlIECCommand");

    if (twpqfilt == null) throw new ProcessingException("Twpqfilt already has nothing assigned.");

    apply(
        new UnAssignTwpqfiltFromWindPlantReactiveControlIECEvent(
            command.getWindPlantReactiveControlIECId()));
  }

  @CommandHandler
  public void handle(AssignTwpufiltToWindPlantReactiveControlIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignTwpufiltToWindPlantReactiveControlIECCommand");

    if (twpufilt != null && twpufilt.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Twpufilt already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTwpufiltToWindPlantReactiveControlIECEvent(
            command.getWindPlantReactiveControlIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTwpufiltFromWindPlantReactiveControlIECCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignTwpufiltFromWindPlantReactiveControlIECCommand");

    if (twpufilt == null) throw new ProcessingException("Twpufilt already has nothing assigned.");

    apply(
        new UnAssignTwpufiltFromWindPlantReactiveControlIECEvent(
            command.getWindPlantReactiveControlIECId()));
  }

  @CommandHandler
  public void handle(AssignTxftToWindPlantReactiveControlIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignTxftToWindPlantReactiveControlIECCommand");

    if (txft != null && txft.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Txft already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTxftToWindPlantReactiveControlIECEvent(
            command.getWindPlantReactiveControlIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTxftFromWindPlantReactiveControlIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTxftFromWindPlantReactiveControlIECCommand");

    if (txft == null) throw new ProcessingException("Txft already has nothing assigned.");

    apply(
        new UnAssignTxftFromWindPlantReactiveControlIECEvent(
            command.getWindPlantReactiveControlIECId()));
  }

  @CommandHandler
  public void handle(AssignTxfvToWindPlantReactiveControlIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignTxfvToWindPlantReactiveControlIECCommand");

    if (txfv != null && txfv.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Txfv already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTxfvToWindPlantReactiveControlIECEvent(
            command.getWindPlantReactiveControlIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTxfvFromWindPlantReactiveControlIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTxfvFromWindPlantReactiveControlIECCommand");

    if (txfv == null) throw new ProcessingException("Txfv already has nothing assigned.");

    apply(
        new UnAssignTxfvFromWindPlantReactiveControlIECEvent(
            command.getWindPlantReactiveControlIECId()));
  }

  @CommandHandler
  public void handle(AssignUwpqdipToWindPlantReactiveControlIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignUwpqdipToWindPlantReactiveControlIECCommand");

    if (uwpqdip != null && uwpqdip.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Uwpqdip already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignUwpqdipToWindPlantReactiveControlIECEvent(
            command.getWindPlantReactiveControlIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignUwpqdipFromWindPlantReactiveControlIECCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignUwpqdipFromWindPlantReactiveControlIECCommand");

    if (uwpqdip == null) throw new ProcessingException("Uwpqdip already has nothing assigned.");

    apply(
        new UnAssignUwpqdipFromWindPlantReactiveControlIECEvent(
            command.getWindPlantReactiveControlIECId()));
  }

  @CommandHandler
  public void handle(AssignXrefmaxToWindPlantReactiveControlIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignXrefmaxToWindPlantReactiveControlIECCommand");

    if (xrefmax != null && xrefmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Xrefmax already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignXrefmaxToWindPlantReactiveControlIECEvent(
            command.getWindPlantReactiveControlIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignXrefmaxFromWindPlantReactiveControlIECCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignXrefmaxFromWindPlantReactiveControlIECCommand");

    if (xrefmax == null) throw new ProcessingException("Xrefmax already has nothing assigned.");

    apply(
        new UnAssignXrefmaxFromWindPlantReactiveControlIECEvent(
            command.getWindPlantReactiveControlIECId()));
  }

  @CommandHandler
  public void handle(AssignXrefminToWindPlantReactiveControlIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignXrefminToWindPlantReactiveControlIECCommand");

    if (xrefmin != null && xrefmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Xrefmin already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignXrefminToWindPlantReactiveControlIECEvent(
            command.getWindPlantReactiveControlIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignXrefminFromWindPlantReactiveControlIECCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignXrefminFromWindPlantReactiveControlIECCommand");

    if (xrefmin == null) throw new ProcessingException("Xrefmin already has nothing assigned.");

    apply(
        new UnAssignXrefminFromWindPlantReactiveControlIECEvent(
            command.getWindPlantReactiveControlIECId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateWindPlantReactiveControlIECEvent event) {
    LOGGER.info("Event sourcing CreateWindPlantReactiveControlIECEvent");
    this.windPlantReactiveControlIECId = event.getWindPlantReactiveControlIECId();
  }

  @EventSourcingHandler
  void on(UpdateWindPlantReactiveControlIECEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.kiwpx = event.getKiwpx();
    this.kpwpx = event.getKpwpx();
    this.kwpqu = event.getKwpqu();
    this.mwppf = event.getMwppf();
    this.mwpu = event.getMwpu();
    this.twppfilt = event.getTwppfilt();
    this.twpqfilt = event.getTwpqfilt();
    this.twpufilt = event.getTwpufilt();
    this.txft = event.getTxft();
    this.txfv = event.getTxfv();
    this.uwpqdip = event.getUwpqdip();
    this.xrefmax = event.getXrefmax();
    this.xrefmin = event.getXrefmin();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignKiwpxToWindPlantReactiveControlIECEvent event) {
    LOGGER.info("Event sourcing AssignKiwpxToWindPlantReactiveControlIECEvent");
    this.kiwpx = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKiwpxFromWindPlantReactiveControlIECEvent event) {
    LOGGER.info("Event sourcing UnAssignKiwpxFromWindPlantReactiveControlIECEvent");
    this.kiwpx = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKpwpxToWindPlantReactiveControlIECEvent event) {
    LOGGER.info("Event sourcing AssignKpwpxToWindPlantReactiveControlIECEvent");
    this.kpwpx = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKpwpxFromWindPlantReactiveControlIECEvent event) {
    LOGGER.info("Event sourcing UnAssignKpwpxFromWindPlantReactiveControlIECEvent");
    this.kpwpx = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKwpquToWindPlantReactiveControlIECEvent event) {
    LOGGER.info("Event sourcing AssignKwpquToWindPlantReactiveControlIECEvent");
    this.kwpqu = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKwpquFromWindPlantReactiveControlIECEvent event) {
    LOGGER.info("Event sourcing UnAssignKwpquFromWindPlantReactiveControlIECEvent");
    this.kwpqu = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMwppfToWindPlantReactiveControlIECEvent event) {
    LOGGER.info("Event sourcing AssignMwppfToWindPlantReactiveControlIECEvent");
    this.mwppf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMwppfFromWindPlantReactiveControlIECEvent event) {
    LOGGER.info("Event sourcing UnAssignMwppfFromWindPlantReactiveControlIECEvent");
    this.mwppf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMwpuToWindPlantReactiveControlIECEvent event) {
    LOGGER.info("Event sourcing AssignMwpuToWindPlantReactiveControlIECEvent");
    this.mwpu = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMwpuFromWindPlantReactiveControlIECEvent event) {
    LOGGER.info("Event sourcing UnAssignMwpuFromWindPlantReactiveControlIECEvent");
    this.mwpu = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTwppfiltToWindPlantReactiveControlIECEvent event) {
    LOGGER.info("Event sourcing AssignTwppfiltToWindPlantReactiveControlIECEvent");
    this.twppfilt = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTwppfiltFromWindPlantReactiveControlIECEvent event) {
    LOGGER.info("Event sourcing UnAssignTwppfiltFromWindPlantReactiveControlIECEvent");
    this.twppfilt = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTwpqfiltToWindPlantReactiveControlIECEvent event) {
    LOGGER.info("Event sourcing AssignTwpqfiltToWindPlantReactiveControlIECEvent");
    this.twpqfilt = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTwpqfiltFromWindPlantReactiveControlIECEvent event) {
    LOGGER.info("Event sourcing UnAssignTwpqfiltFromWindPlantReactiveControlIECEvent");
    this.twpqfilt = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTwpufiltToWindPlantReactiveControlIECEvent event) {
    LOGGER.info("Event sourcing AssignTwpufiltToWindPlantReactiveControlIECEvent");
    this.twpufilt = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTwpufiltFromWindPlantReactiveControlIECEvent event) {
    LOGGER.info("Event sourcing UnAssignTwpufiltFromWindPlantReactiveControlIECEvent");
    this.twpufilt = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTxftToWindPlantReactiveControlIECEvent event) {
    LOGGER.info("Event sourcing AssignTxftToWindPlantReactiveControlIECEvent");
    this.txft = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTxftFromWindPlantReactiveControlIECEvent event) {
    LOGGER.info("Event sourcing UnAssignTxftFromWindPlantReactiveControlIECEvent");
    this.txft = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTxfvToWindPlantReactiveControlIECEvent event) {
    LOGGER.info("Event sourcing AssignTxfvToWindPlantReactiveControlIECEvent");
    this.txfv = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTxfvFromWindPlantReactiveControlIECEvent event) {
    LOGGER.info("Event sourcing UnAssignTxfvFromWindPlantReactiveControlIECEvent");
    this.txfv = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignUwpqdipToWindPlantReactiveControlIECEvent event) {
    LOGGER.info("Event sourcing AssignUwpqdipToWindPlantReactiveControlIECEvent");
    this.uwpqdip = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignUwpqdipFromWindPlantReactiveControlIECEvent event) {
    LOGGER.info("Event sourcing UnAssignUwpqdipFromWindPlantReactiveControlIECEvent");
    this.uwpqdip = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignXrefmaxToWindPlantReactiveControlIECEvent event) {
    LOGGER.info("Event sourcing AssignXrefmaxToWindPlantReactiveControlIECEvent");
    this.xrefmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignXrefmaxFromWindPlantReactiveControlIECEvent event) {
    LOGGER.info("Event sourcing UnAssignXrefmaxFromWindPlantReactiveControlIECEvent");
    this.xrefmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignXrefminToWindPlantReactiveControlIECEvent event) {
    LOGGER.info("Event sourcing AssignXrefminToWindPlantReactiveControlIECEvent");
    this.xrefmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignXrefminFromWindPlantReactiveControlIECEvent event) {
    LOGGER.info("Event sourcing UnAssignXrefminFromWindPlantReactiveControlIECEvent");
    this.xrefmin = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID windPlantReactiveControlIECId;

  private Simple_Float kiwpx = null;
  private Simple_Float kpwpx = null;
  private PU kwpqu = null;
  private BooleanProxy mwppf = null;
  private BooleanProxy mwpu = null;
  private Seconds twppfilt = null;
  private Seconds twpqfilt = null;
  private Seconds twpufilt = null;
  private Seconds txft = null;
  private Seconds txfv = null;
  private PU uwpqdip = null;
  private PU xrefmax = null;
  private PU xrefmin = null;

  private static final Logger LOGGER =
      Logger.getLogger(WindPlantReactiveControlIECAggregate.class.getName());
}
