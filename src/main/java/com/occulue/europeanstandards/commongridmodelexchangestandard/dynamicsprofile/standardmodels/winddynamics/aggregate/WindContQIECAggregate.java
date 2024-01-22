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
 * Aggregate handler for WindContQIEC as outlined for the CQRS pattern, all write responsibilities
 * related to WindContQIEC are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class WindContQIECAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public WindContQIECAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public WindContQIECAggregate(CreateWindContQIECCommand command) throws Exception {
    LOGGER.info("Handling command CreateWindContQIECCommand");
    CreateWindContQIECEvent event =
        new CreateWindContQIECEvent(
            command.getWindContQIECId(),
            command.getWindLVRTQcontrolModesType(),
            command.getWindQcontrolModesType());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateWindContQIECCommand command) throws Exception {
    LOGGER.info("handling command UpdateWindContQIECCommand");
    UpdateWindContQIECEvent event =
        new UpdateWindContQIECEvent(
            command.getWindContQIECId(),
            command.getIqh1(),
            command.getIqmax(),
            command.getIqmin(),
            command.getIqpost(),
            command.getKiq(),
            command.getKiu(),
            command.getKpq(),
            command.getKpu(),
            command.getKqv(),
            command.getQmax(),
            command.getQmin(),
            command.getRdroop(),
            command.getTiq(),
            command.getTpfilt(),
            command.getTpost(),
            command.getTqord(),
            command.getTufilt(),
            command.getUdb1(),
            command.getUdb2(),
            command.getUmax(),
            command.getUmin(),
            command.getUqdip(),
            command.getUref0(),
            command.getWindLVRTQcontrolModesType(),
            command.getWindQcontrolModesType(),
            command.getXdroop());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteWindContQIECCommand command) throws Exception {
    LOGGER.info("Handling command DeleteWindContQIECCommand");
    apply(new DeleteWindContQIECEvent(command.getWindContQIECId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignIqh1ToWindContQIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignIqh1ToWindContQIECCommand");

    if (iqh1 != null && iqh1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Iqh1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignIqh1ToWindContQIECEvent(command.getWindContQIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignIqh1FromWindContQIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignIqh1FromWindContQIECCommand");

    if (iqh1 == null) throw new ProcessingException("Iqh1 already has nothing assigned.");

    apply(new UnAssignIqh1FromWindContQIECEvent(command.getWindContQIECId()));
  }

  @CommandHandler
  public void handle(AssignIqmaxToWindContQIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignIqmaxToWindContQIECCommand");

    if (iqmax != null && iqmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Iqmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignIqmaxToWindContQIECEvent(command.getWindContQIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignIqmaxFromWindContQIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignIqmaxFromWindContQIECCommand");

    if (iqmax == null) throw new ProcessingException("Iqmax already has nothing assigned.");

    apply(new UnAssignIqmaxFromWindContQIECEvent(command.getWindContQIECId()));
  }

  @CommandHandler
  public void handle(AssignIqminToWindContQIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignIqminToWindContQIECCommand");

    if (iqmin != null && iqmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Iqmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignIqminToWindContQIECEvent(command.getWindContQIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignIqminFromWindContQIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignIqminFromWindContQIECCommand");

    if (iqmin == null) throw new ProcessingException("Iqmin already has nothing assigned.");

    apply(new UnAssignIqminFromWindContQIECEvent(command.getWindContQIECId()));
  }

  @CommandHandler
  public void handle(AssignIqpostToWindContQIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignIqpostToWindContQIECCommand");

    if (iqpost != null && iqpost.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Iqpost already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignIqpostToWindContQIECEvent(command.getWindContQIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignIqpostFromWindContQIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignIqpostFromWindContQIECCommand");

    if (iqpost == null) throw new ProcessingException("Iqpost already has nothing assigned.");

    apply(new UnAssignIqpostFromWindContQIECEvent(command.getWindContQIECId()));
  }

  @CommandHandler
  public void handle(AssignKiqToWindContQIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignKiqToWindContQIECCommand");

    if (kiq != null && kiq.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kiq already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKiqToWindContQIECEvent(command.getWindContQIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKiqFromWindContQIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKiqFromWindContQIECCommand");

    if (kiq == null) throw new ProcessingException("Kiq already has nothing assigned.");

    apply(new UnAssignKiqFromWindContQIECEvent(command.getWindContQIECId()));
  }

  @CommandHandler
  public void handle(AssignKiuToWindContQIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignKiuToWindContQIECCommand");

    if (kiu != null && kiu.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kiu already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKiuToWindContQIECEvent(command.getWindContQIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKiuFromWindContQIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKiuFromWindContQIECCommand");

    if (kiu == null) throw new ProcessingException("Kiu already has nothing assigned.");

    apply(new UnAssignKiuFromWindContQIECEvent(command.getWindContQIECId()));
  }

  @CommandHandler
  public void handle(AssignKpqToWindContQIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignKpqToWindContQIECCommand");

    if (kpq != null && kpq.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kpq already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKpqToWindContQIECEvent(command.getWindContQIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKpqFromWindContQIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKpqFromWindContQIECCommand");

    if (kpq == null) throw new ProcessingException("Kpq already has nothing assigned.");

    apply(new UnAssignKpqFromWindContQIECEvent(command.getWindContQIECId()));
  }

  @CommandHandler
  public void handle(AssignKpuToWindContQIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignKpuToWindContQIECCommand");

    if (kpu != null && kpu.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kpu already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKpuToWindContQIECEvent(command.getWindContQIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKpuFromWindContQIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKpuFromWindContQIECCommand");

    if (kpu == null) throw new ProcessingException("Kpu already has nothing assigned.");

    apply(new UnAssignKpuFromWindContQIECEvent(command.getWindContQIECId()));
  }

  @CommandHandler
  public void handle(AssignKqvToWindContQIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignKqvToWindContQIECCommand");

    if (kqv != null && kqv.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kqv already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKqvToWindContQIECEvent(command.getWindContQIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKqvFromWindContQIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKqvFromWindContQIECCommand");

    if (kqv == null) throw new ProcessingException("Kqv already has nothing assigned.");

    apply(new UnAssignKqvFromWindContQIECEvent(command.getWindContQIECId()));
  }

  @CommandHandler
  public void handle(AssignQmaxToWindContQIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignQmaxToWindContQIECCommand");

    if (qmax != null && qmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Qmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignQmaxToWindContQIECEvent(command.getWindContQIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignQmaxFromWindContQIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignQmaxFromWindContQIECCommand");

    if (qmax == null) throw new ProcessingException("Qmax already has nothing assigned.");

    apply(new UnAssignQmaxFromWindContQIECEvent(command.getWindContQIECId()));
  }

  @CommandHandler
  public void handle(AssignQminToWindContQIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignQminToWindContQIECCommand");

    if (qmin != null && qmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Qmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignQminToWindContQIECEvent(command.getWindContQIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignQminFromWindContQIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignQminFromWindContQIECCommand");

    if (qmin == null) throw new ProcessingException("Qmin already has nothing assigned.");

    apply(new UnAssignQminFromWindContQIECEvent(command.getWindContQIECId()));
  }

  @CommandHandler
  public void handle(AssignRdroopToWindContQIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignRdroopToWindContQIECCommand");

    if (rdroop != null && rdroop.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Rdroop already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignRdroopToWindContQIECEvent(command.getWindContQIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRdroopFromWindContQIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignRdroopFromWindContQIECCommand");

    if (rdroop == null) throw new ProcessingException("Rdroop already has nothing assigned.");

    apply(new UnAssignRdroopFromWindContQIECEvent(command.getWindContQIECId()));
  }

  @CommandHandler
  public void handle(AssignTiqToWindContQIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignTiqToWindContQIECCommand");

    if (tiq != null && tiq.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tiq already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTiqToWindContQIECEvent(command.getWindContQIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTiqFromWindContQIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTiqFromWindContQIECCommand");

    if (tiq == null) throw new ProcessingException("Tiq already has nothing assigned.");

    apply(new UnAssignTiqFromWindContQIECEvent(command.getWindContQIECId()));
  }

  @CommandHandler
  public void handle(AssignTpfiltToWindContQIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignTpfiltToWindContQIECCommand");

    if (tpfilt != null && tpfilt.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tpfilt already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTpfiltToWindContQIECEvent(command.getWindContQIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTpfiltFromWindContQIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTpfiltFromWindContQIECCommand");

    if (tpfilt == null) throw new ProcessingException("Tpfilt already has nothing assigned.");

    apply(new UnAssignTpfiltFromWindContQIECEvent(command.getWindContQIECId()));
  }

  @CommandHandler
  public void handle(AssignTpostToWindContQIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignTpostToWindContQIECCommand");

    if (tpost != null && tpost.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tpost already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTpostToWindContQIECEvent(command.getWindContQIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTpostFromWindContQIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTpostFromWindContQIECCommand");

    if (tpost == null) throw new ProcessingException("Tpost already has nothing assigned.");

    apply(new UnAssignTpostFromWindContQIECEvent(command.getWindContQIECId()));
  }

  @CommandHandler
  public void handle(AssignTqordToWindContQIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignTqordToWindContQIECCommand");

    if (tqord != null && tqord.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tqord already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTqordToWindContQIECEvent(command.getWindContQIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTqordFromWindContQIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTqordFromWindContQIECCommand");

    if (tqord == null) throw new ProcessingException("Tqord already has nothing assigned.");

    apply(new UnAssignTqordFromWindContQIECEvent(command.getWindContQIECId()));
  }

  @CommandHandler
  public void handle(AssignTufiltToWindContQIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignTufiltToWindContQIECCommand");

    if (tufilt != null && tufilt.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tufilt already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTufiltToWindContQIECEvent(command.getWindContQIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTufiltFromWindContQIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTufiltFromWindContQIECCommand");

    if (tufilt == null) throw new ProcessingException("Tufilt already has nothing assigned.");

    apply(new UnAssignTufiltFromWindContQIECEvent(command.getWindContQIECId()));
  }

  @CommandHandler
  public void handle(AssignUdb1ToWindContQIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignUdb1ToWindContQIECCommand");

    if (udb1 != null && udb1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Udb1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignUdb1ToWindContQIECEvent(command.getWindContQIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignUdb1FromWindContQIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignUdb1FromWindContQIECCommand");

    if (udb1 == null) throw new ProcessingException("Udb1 already has nothing assigned.");

    apply(new UnAssignUdb1FromWindContQIECEvent(command.getWindContQIECId()));
  }

  @CommandHandler
  public void handle(AssignUdb2ToWindContQIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignUdb2ToWindContQIECCommand");

    if (udb2 != null && udb2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Udb2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignUdb2ToWindContQIECEvent(command.getWindContQIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignUdb2FromWindContQIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignUdb2FromWindContQIECCommand");

    if (udb2 == null) throw new ProcessingException("Udb2 already has nothing assigned.");

    apply(new UnAssignUdb2FromWindContQIECEvent(command.getWindContQIECId()));
  }

  @CommandHandler
  public void handle(AssignUmaxToWindContQIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignUmaxToWindContQIECCommand");

    if (umax != null && umax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Umax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignUmaxToWindContQIECEvent(command.getWindContQIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignUmaxFromWindContQIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignUmaxFromWindContQIECCommand");

    if (umax == null) throw new ProcessingException("Umax already has nothing assigned.");

    apply(new UnAssignUmaxFromWindContQIECEvent(command.getWindContQIECId()));
  }

  @CommandHandler
  public void handle(AssignUminToWindContQIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignUminToWindContQIECCommand");

    if (umin != null && umin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Umin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignUminToWindContQIECEvent(command.getWindContQIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignUminFromWindContQIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignUminFromWindContQIECCommand");

    if (umin == null) throw new ProcessingException("Umin already has nothing assigned.");

    apply(new UnAssignUminFromWindContQIECEvent(command.getWindContQIECId()));
  }

  @CommandHandler
  public void handle(AssignUqdipToWindContQIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignUqdipToWindContQIECCommand");

    if (uqdip != null && uqdip.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Uqdip already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignUqdipToWindContQIECEvent(command.getWindContQIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignUqdipFromWindContQIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignUqdipFromWindContQIECCommand");

    if (uqdip == null) throw new ProcessingException("Uqdip already has nothing assigned.");

    apply(new UnAssignUqdipFromWindContQIECEvent(command.getWindContQIECId()));
  }

  @CommandHandler
  public void handle(AssignUref0ToWindContQIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignUref0ToWindContQIECCommand");

    if (uref0 != null && uref0.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Uref0 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignUref0ToWindContQIECEvent(command.getWindContQIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignUref0FromWindContQIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignUref0FromWindContQIECCommand");

    if (uref0 == null) throw new ProcessingException("Uref0 already has nothing assigned.");

    apply(new UnAssignUref0FromWindContQIECEvent(command.getWindContQIECId()));
  }

  @CommandHandler
  public void handle(AssignXdroopToWindContQIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignXdroopToWindContQIECCommand");

    if (xdroop != null && xdroop.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Xdroop already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignXdroopToWindContQIECEvent(command.getWindContQIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignXdroopFromWindContQIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignXdroopFromWindContQIECCommand");

    if (xdroop == null) throw new ProcessingException("Xdroop already has nothing assigned.");

    apply(new UnAssignXdroopFromWindContQIECEvent(command.getWindContQIECId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateWindContQIECEvent event) {
    LOGGER.info("Event sourcing CreateWindContQIECEvent");
    this.windContQIECId = event.getWindContQIECId();
    this.windLVRTQcontrolModesType = event.getWindLVRTQcontrolModesType();
    this.windQcontrolModesType = event.getWindQcontrolModesType();
  }

  @EventSourcingHandler
  void on(UpdateWindContQIECEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.iqh1 = event.getIqh1();
    this.iqmax = event.getIqmax();
    this.iqmin = event.getIqmin();
    this.iqpost = event.getIqpost();
    this.kiq = event.getKiq();
    this.kiu = event.getKiu();
    this.kpq = event.getKpq();
    this.kpu = event.getKpu();
    this.kqv = event.getKqv();
    this.qmax = event.getQmax();
    this.qmin = event.getQmin();
    this.rdroop = event.getRdroop();
    this.tiq = event.getTiq();
    this.tpfilt = event.getTpfilt();
    this.tpost = event.getTpost();
    this.tqord = event.getTqord();
    this.tufilt = event.getTufilt();
    this.udb1 = event.getUdb1();
    this.udb2 = event.getUdb2();
    this.umax = event.getUmax();
    this.umin = event.getUmin();
    this.uqdip = event.getUqdip();
    this.uref0 = event.getUref0();
    this.windLVRTQcontrolModesType = event.getWindLVRTQcontrolModesType();
    this.windQcontrolModesType = event.getWindQcontrolModesType();
    this.xdroop = event.getXdroop();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignIqh1ToWindContQIECEvent event) {
    LOGGER.info("Event sourcing AssignIqh1ToWindContQIECEvent");
    this.iqh1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignIqh1FromWindContQIECEvent event) {
    LOGGER.info("Event sourcing UnAssignIqh1FromWindContQIECEvent");
    this.iqh1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignIqmaxToWindContQIECEvent event) {
    LOGGER.info("Event sourcing AssignIqmaxToWindContQIECEvent");
    this.iqmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignIqmaxFromWindContQIECEvent event) {
    LOGGER.info("Event sourcing UnAssignIqmaxFromWindContQIECEvent");
    this.iqmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignIqminToWindContQIECEvent event) {
    LOGGER.info("Event sourcing AssignIqminToWindContQIECEvent");
    this.iqmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignIqminFromWindContQIECEvent event) {
    LOGGER.info("Event sourcing UnAssignIqminFromWindContQIECEvent");
    this.iqmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignIqpostToWindContQIECEvent event) {
    LOGGER.info("Event sourcing AssignIqpostToWindContQIECEvent");
    this.iqpost = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignIqpostFromWindContQIECEvent event) {
    LOGGER.info("Event sourcing UnAssignIqpostFromWindContQIECEvent");
    this.iqpost = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKiqToWindContQIECEvent event) {
    LOGGER.info("Event sourcing AssignKiqToWindContQIECEvent");
    this.kiq = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKiqFromWindContQIECEvent event) {
    LOGGER.info("Event sourcing UnAssignKiqFromWindContQIECEvent");
    this.kiq = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKiuToWindContQIECEvent event) {
    LOGGER.info("Event sourcing AssignKiuToWindContQIECEvent");
    this.kiu = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKiuFromWindContQIECEvent event) {
    LOGGER.info("Event sourcing UnAssignKiuFromWindContQIECEvent");
    this.kiu = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKpqToWindContQIECEvent event) {
    LOGGER.info("Event sourcing AssignKpqToWindContQIECEvent");
    this.kpq = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKpqFromWindContQIECEvent event) {
    LOGGER.info("Event sourcing UnAssignKpqFromWindContQIECEvent");
    this.kpq = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKpuToWindContQIECEvent event) {
    LOGGER.info("Event sourcing AssignKpuToWindContQIECEvent");
    this.kpu = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKpuFromWindContQIECEvent event) {
    LOGGER.info("Event sourcing UnAssignKpuFromWindContQIECEvent");
    this.kpu = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKqvToWindContQIECEvent event) {
    LOGGER.info("Event sourcing AssignKqvToWindContQIECEvent");
    this.kqv = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKqvFromWindContQIECEvent event) {
    LOGGER.info("Event sourcing UnAssignKqvFromWindContQIECEvent");
    this.kqv = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignQmaxToWindContQIECEvent event) {
    LOGGER.info("Event sourcing AssignQmaxToWindContQIECEvent");
    this.qmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignQmaxFromWindContQIECEvent event) {
    LOGGER.info("Event sourcing UnAssignQmaxFromWindContQIECEvent");
    this.qmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignQminToWindContQIECEvent event) {
    LOGGER.info("Event sourcing AssignQminToWindContQIECEvent");
    this.qmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignQminFromWindContQIECEvent event) {
    LOGGER.info("Event sourcing UnAssignQminFromWindContQIECEvent");
    this.qmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRdroopToWindContQIECEvent event) {
    LOGGER.info("Event sourcing AssignRdroopToWindContQIECEvent");
    this.rdroop = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRdroopFromWindContQIECEvent event) {
    LOGGER.info("Event sourcing UnAssignRdroopFromWindContQIECEvent");
    this.rdroop = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTiqToWindContQIECEvent event) {
    LOGGER.info("Event sourcing AssignTiqToWindContQIECEvent");
    this.tiq = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTiqFromWindContQIECEvent event) {
    LOGGER.info("Event sourcing UnAssignTiqFromWindContQIECEvent");
    this.tiq = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTpfiltToWindContQIECEvent event) {
    LOGGER.info("Event sourcing AssignTpfiltToWindContQIECEvent");
    this.tpfilt = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTpfiltFromWindContQIECEvent event) {
    LOGGER.info("Event sourcing UnAssignTpfiltFromWindContQIECEvent");
    this.tpfilt = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTpostToWindContQIECEvent event) {
    LOGGER.info("Event sourcing AssignTpostToWindContQIECEvent");
    this.tpost = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTpostFromWindContQIECEvent event) {
    LOGGER.info("Event sourcing UnAssignTpostFromWindContQIECEvent");
    this.tpost = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTqordToWindContQIECEvent event) {
    LOGGER.info("Event sourcing AssignTqordToWindContQIECEvent");
    this.tqord = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTqordFromWindContQIECEvent event) {
    LOGGER.info("Event sourcing UnAssignTqordFromWindContQIECEvent");
    this.tqord = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTufiltToWindContQIECEvent event) {
    LOGGER.info("Event sourcing AssignTufiltToWindContQIECEvent");
    this.tufilt = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTufiltFromWindContQIECEvent event) {
    LOGGER.info("Event sourcing UnAssignTufiltFromWindContQIECEvent");
    this.tufilt = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignUdb1ToWindContQIECEvent event) {
    LOGGER.info("Event sourcing AssignUdb1ToWindContQIECEvent");
    this.udb1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignUdb1FromWindContQIECEvent event) {
    LOGGER.info("Event sourcing UnAssignUdb1FromWindContQIECEvent");
    this.udb1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignUdb2ToWindContQIECEvent event) {
    LOGGER.info("Event sourcing AssignUdb2ToWindContQIECEvent");
    this.udb2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignUdb2FromWindContQIECEvent event) {
    LOGGER.info("Event sourcing UnAssignUdb2FromWindContQIECEvent");
    this.udb2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignUmaxToWindContQIECEvent event) {
    LOGGER.info("Event sourcing AssignUmaxToWindContQIECEvent");
    this.umax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignUmaxFromWindContQIECEvent event) {
    LOGGER.info("Event sourcing UnAssignUmaxFromWindContQIECEvent");
    this.umax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignUminToWindContQIECEvent event) {
    LOGGER.info("Event sourcing AssignUminToWindContQIECEvent");
    this.umin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignUminFromWindContQIECEvent event) {
    LOGGER.info("Event sourcing UnAssignUminFromWindContQIECEvent");
    this.umin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignUqdipToWindContQIECEvent event) {
    LOGGER.info("Event sourcing AssignUqdipToWindContQIECEvent");
    this.uqdip = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignUqdipFromWindContQIECEvent event) {
    LOGGER.info("Event sourcing UnAssignUqdipFromWindContQIECEvent");
    this.uqdip = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignUref0ToWindContQIECEvent event) {
    LOGGER.info("Event sourcing AssignUref0ToWindContQIECEvent");
    this.uref0 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignUref0FromWindContQIECEvent event) {
    LOGGER.info("Event sourcing UnAssignUref0FromWindContQIECEvent");
    this.uref0 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignXdroopToWindContQIECEvent event) {
    LOGGER.info("Event sourcing AssignXdroopToWindContQIECEvent");
    this.xdroop = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignXdroopFromWindContQIECEvent event) {
    LOGGER.info("Event sourcing UnAssignXdroopFromWindContQIECEvent");
    this.xdroop = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID windContQIECId;

  private WindLVRTQcontrolModesKind windLVRTQcontrolModesType;
  private WindQcontrolModesKind windQcontrolModesType;
  private PU iqh1 = null;
  private PU iqmax = null;
  private PU iqmin = null;
  private PU iqpost = null;
  private PU kiq = null;
  private PU kiu = null;
  private PU kpq = null;
  private PU kpu = null;
  private PU kqv = null;
  private PU qmax = null;
  private PU qmin = null;
  private PU rdroop = null;
  private Seconds tiq = null;
  private Seconds tpfilt = null;
  private Seconds tpost = null;
  private Seconds tqord = null;
  private Seconds tufilt = null;
  private PU udb1 = null;
  private PU udb2 = null;
  private PU umax = null;
  private PU umin = null;
  private PU uqdip = null;
  private PU uref0 = null;
  private PU xdroop = null;

  private static final Logger LOGGER = Logger.getLogger(WindContQIECAggregate.class.getName());
}
