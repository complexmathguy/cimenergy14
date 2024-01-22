package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.discontinuousexcitationcontroldynamics.aggregate;

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
 * Aggregate handler for DiscExcContIEEEDEC1A as outlined for the CQRS pattern, all write
 * responsibilities related to DiscExcContIEEEDEC1A are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class DiscExcContIEEEDEC1AAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public DiscExcContIEEEDEC1AAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public DiscExcContIEEEDEC1AAggregate(CreateDiscExcContIEEEDEC1ACommand command) throws Exception {
    LOGGER.info("Handling command CreateDiscExcContIEEEDEC1ACommand");
    CreateDiscExcContIEEEDEC1AEvent event =
        new CreateDiscExcContIEEEDEC1AEvent(command.getDiscExcContIEEEDEC1AId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateDiscExcContIEEEDEC1ACommand command) throws Exception {
    LOGGER.info("handling command UpdateDiscExcContIEEEDEC1ACommand");
    UpdateDiscExcContIEEEDEC1AEvent event =
        new UpdateDiscExcContIEEEDEC1AEvent(
            command.getDiscExcContIEEEDEC1AId(),
            command.getEsc(),
            command.getKan(),
            command.getKetl(),
            command.getTan(),
            command.getTd(),
            command.getTl1(),
            command.getTl2(),
            command.getTw5(),
            command.getValue(),
            command.getVanmax(),
            command.getVomax(),
            command.getVomin(),
            command.getVsmax(),
            command.getVsmin(),
            command.getVtc(),
            command.getVtlmt(),
            command.getVtm(),
            command.getVtn());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteDiscExcContIEEEDEC1ACommand command) throws Exception {
    LOGGER.info("Handling command DeleteDiscExcContIEEEDEC1ACommand");
    apply(new DeleteDiscExcContIEEEDEC1AEvent(command.getDiscExcContIEEEDEC1AId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignEscToDiscExcContIEEEDEC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignEscToDiscExcContIEEEDEC1ACommand");

    if (esc != null && esc.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Esc already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignEscToDiscExcContIEEEDEC1AEvent(
            command.getDiscExcContIEEEDEC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEscFromDiscExcContIEEEDEC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignEscFromDiscExcContIEEEDEC1ACommand");

    if (esc == null) throw new ProcessingException("Esc already has nothing assigned.");

    apply(new UnAssignEscFromDiscExcContIEEEDEC1AEvent(command.getDiscExcContIEEEDEC1AId()));
  }

  @CommandHandler
  public void handle(AssignKanToDiscExcContIEEEDEC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKanToDiscExcContIEEEDEC1ACommand");

    if (kan != null && kan.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kan already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignKanToDiscExcContIEEEDEC1AEvent(
            command.getDiscExcContIEEEDEC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKanFromDiscExcContIEEEDEC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKanFromDiscExcContIEEEDEC1ACommand");

    if (kan == null) throw new ProcessingException("Kan already has nothing assigned.");

    apply(new UnAssignKanFromDiscExcContIEEEDEC1AEvent(command.getDiscExcContIEEEDEC1AId()));
  }

  @CommandHandler
  public void handle(AssignKetlToDiscExcContIEEEDEC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignKetlToDiscExcContIEEEDEC1ACommand");

    if (ketl != null && ketl.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ketl already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignKetlToDiscExcContIEEEDEC1AEvent(
            command.getDiscExcContIEEEDEC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKetlFromDiscExcContIEEEDEC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKetlFromDiscExcContIEEEDEC1ACommand");

    if (ketl == null) throw new ProcessingException("Ketl already has nothing assigned.");

    apply(new UnAssignKetlFromDiscExcContIEEEDEC1AEvent(command.getDiscExcContIEEEDEC1AId()));
  }

  @CommandHandler
  public void handle(AssignTanToDiscExcContIEEEDEC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTanToDiscExcContIEEEDEC1ACommand");

    if (tan != null && tan.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tan already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTanToDiscExcContIEEEDEC1AEvent(
            command.getDiscExcContIEEEDEC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTanFromDiscExcContIEEEDEC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTanFromDiscExcContIEEEDEC1ACommand");

    if (tan == null) throw new ProcessingException("Tan already has nothing assigned.");

    apply(new UnAssignTanFromDiscExcContIEEEDEC1AEvent(command.getDiscExcContIEEEDEC1AId()));
  }

  @CommandHandler
  public void handle(AssignTdToDiscExcContIEEEDEC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTdToDiscExcContIEEEDEC1ACommand");

    if (td != null && td.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Td already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTdToDiscExcContIEEEDEC1AEvent(
            command.getDiscExcContIEEEDEC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTdFromDiscExcContIEEEDEC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTdFromDiscExcContIEEEDEC1ACommand");

    if (td == null) throw new ProcessingException("Td already has nothing assigned.");

    apply(new UnAssignTdFromDiscExcContIEEEDEC1AEvent(command.getDiscExcContIEEEDEC1AId()));
  }

  @CommandHandler
  public void handle(AssignTl1ToDiscExcContIEEEDEC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTl1ToDiscExcContIEEEDEC1ACommand");

    if (tl1 != null && tl1.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tl1 already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTl1ToDiscExcContIEEEDEC1AEvent(
            command.getDiscExcContIEEEDEC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTl1FromDiscExcContIEEEDEC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTl1FromDiscExcContIEEEDEC1ACommand");

    if (tl1 == null) throw new ProcessingException("Tl1 already has nothing assigned.");

    apply(new UnAssignTl1FromDiscExcContIEEEDEC1AEvent(command.getDiscExcContIEEEDEC1AId()));
  }

  @CommandHandler
  public void handle(AssignTl2ToDiscExcContIEEEDEC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTl2ToDiscExcContIEEEDEC1ACommand");

    if (tl2 != null && tl2.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tl2 already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTl2ToDiscExcContIEEEDEC1AEvent(
            command.getDiscExcContIEEEDEC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTl2FromDiscExcContIEEEDEC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTl2FromDiscExcContIEEEDEC1ACommand");

    if (tl2 == null) throw new ProcessingException("Tl2 already has nothing assigned.");

    apply(new UnAssignTl2FromDiscExcContIEEEDEC1AEvent(command.getDiscExcContIEEEDEC1AId()));
  }

  @CommandHandler
  public void handle(AssignTw5ToDiscExcContIEEEDEC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignTw5ToDiscExcContIEEEDEC1ACommand");

    if (tw5 != null && tw5.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tw5 already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTw5ToDiscExcContIEEEDEC1AEvent(
            command.getDiscExcContIEEEDEC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTw5FromDiscExcContIEEEDEC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTw5FromDiscExcContIEEEDEC1ACommand");

    if (tw5 == null) throw new ProcessingException("Tw5 already has nothing assigned.");

    apply(new UnAssignTw5FromDiscExcContIEEEDEC1AEvent(command.getDiscExcContIEEEDEC1AId()));
  }

  @CommandHandler
  public void handle(AssignValueToDiscExcContIEEEDEC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignValueToDiscExcContIEEEDEC1ACommand");

    if (value != null && value.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Value already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignValueToDiscExcContIEEEDEC1AEvent(
            command.getDiscExcContIEEEDEC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignValueFromDiscExcContIEEEDEC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignValueFromDiscExcContIEEEDEC1ACommand");

    if (value == null) throw new ProcessingException("Value already has nothing assigned.");

    apply(new UnAssignValueFromDiscExcContIEEEDEC1AEvent(command.getDiscExcContIEEEDEC1AId()));
  }

  @CommandHandler
  public void handle(AssignVanmaxToDiscExcContIEEEDEC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVanmaxToDiscExcContIEEEDEC1ACommand");

    if (vanmax != null && vanmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vanmax already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignVanmaxToDiscExcContIEEEDEC1AEvent(
            command.getDiscExcContIEEEDEC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVanmaxFromDiscExcContIEEEDEC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVanmaxFromDiscExcContIEEEDEC1ACommand");

    if (vanmax == null) throw new ProcessingException("Vanmax already has nothing assigned.");

    apply(new UnAssignVanmaxFromDiscExcContIEEEDEC1AEvent(command.getDiscExcContIEEEDEC1AId()));
  }

  @CommandHandler
  public void handle(AssignVomaxToDiscExcContIEEEDEC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVomaxToDiscExcContIEEEDEC1ACommand");

    if (vomax != null && vomax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vomax already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignVomaxToDiscExcContIEEEDEC1AEvent(
            command.getDiscExcContIEEEDEC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVomaxFromDiscExcContIEEEDEC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVomaxFromDiscExcContIEEEDEC1ACommand");

    if (vomax == null) throw new ProcessingException("Vomax already has nothing assigned.");

    apply(new UnAssignVomaxFromDiscExcContIEEEDEC1AEvent(command.getDiscExcContIEEEDEC1AId()));
  }

  @CommandHandler
  public void handle(AssignVominToDiscExcContIEEEDEC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVominToDiscExcContIEEEDEC1ACommand");

    if (vomin != null && vomin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vomin already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignVominToDiscExcContIEEEDEC1AEvent(
            command.getDiscExcContIEEEDEC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVominFromDiscExcContIEEEDEC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVominFromDiscExcContIEEEDEC1ACommand");

    if (vomin == null) throw new ProcessingException("Vomin already has nothing assigned.");

    apply(new UnAssignVominFromDiscExcContIEEEDEC1AEvent(command.getDiscExcContIEEEDEC1AId()));
  }

  @CommandHandler
  public void handle(AssignVsmaxToDiscExcContIEEEDEC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVsmaxToDiscExcContIEEEDEC1ACommand");

    if (vsmax != null && vsmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vsmax already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignVsmaxToDiscExcContIEEEDEC1AEvent(
            command.getDiscExcContIEEEDEC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVsmaxFromDiscExcContIEEEDEC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVsmaxFromDiscExcContIEEEDEC1ACommand");

    if (vsmax == null) throw new ProcessingException("Vsmax already has nothing assigned.");

    apply(new UnAssignVsmaxFromDiscExcContIEEEDEC1AEvent(command.getDiscExcContIEEEDEC1AId()));
  }

  @CommandHandler
  public void handle(AssignVsminToDiscExcContIEEEDEC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVsminToDiscExcContIEEEDEC1ACommand");

    if (vsmin != null && vsmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vsmin already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignVsminToDiscExcContIEEEDEC1AEvent(
            command.getDiscExcContIEEEDEC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVsminFromDiscExcContIEEEDEC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVsminFromDiscExcContIEEEDEC1ACommand");

    if (vsmin == null) throw new ProcessingException("Vsmin already has nothing assigned.");

    apply(new UnAssignVsminFromDiscExcContIEEEDEC1AEvent(command.getDiscExcContIEEEDEC1AId()));
  }

  @CommandHandler
  public void handle(AssignVtcToDiscExcContIEEEDEC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVtcToDiscExcContIEEEDEC1ACommand");

    if (vtc != null && vtc.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vtc already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignVtcToDiscExcContIEEEDEC1AEvent(
            command.getDiscExcContIEEEDEC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVtcFromDiscExcContIEEEDEC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVtcFromDiscExcContIEEEDEC1ACommand");

    if (vtc == null) throw new ProcessingException("Vtc already has nothing assigned.");

    apply(new UnAssignVtcFromDiscExcContIEEEDEC1AEvent(command.getDiscExcContIEEEDEC1AId()));
  }

  @CommandHandler
  public void handle(AssignVtlmtToDiscExcContIEEEDEC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVtlmtToDiscExcContIEEEDEC1ACommand");

    if (vtlmt != null && vtlmt.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vtlmt already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignVtlmtToDiscExcContIEEEDEC1AEvent(
            command.getDiscExcContIEEEDEC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVtlmtFromDiscExcContIEEEDEC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVtlmtFromDiscExcContIEEEDEC1ACommand");

    if (vtlmt == null) throw new ProcessingException("Vtlmt already has nothing assigned.");

    apply(new UnAssignVtlmtFromDiscExcContIEEEDEC1AEvent(command.getDiscExcContIEEEDEC1AId()));
  }

  @CommandHandler
  public void handle(AssignVtmToDiscExcContIEEEDEC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVtmToDiscExcContIEEEDEC1ACommand");

    if (vtm != null && vtm.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vtm already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignVtmToDiscExcContIEEEDEC1AEvent(
            command.getDiscExcContIEEEDEC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVtmFromDiscExcContIEEEDEC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVtmFromDiscExcContIEEEDEC1ACommand");

    if (vtm == null) throw new ProcessingException("Vtm already has nothing assigned.");

    apply(new UnAssignVtmFromDiscExcContIEEEDEC1AEvent(command.getDiscExcContIEEEDEC1AId()));
  }

  @CommandHandler
  public void handle(AssignVtnToDiscExcContIEEEDEC1ACommand command) throws Exception {
    LOGGER.info("Handling command AssignVtnToDiscExcContIEEEDEC1ACommand");

    if (vtn != null && vtn.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vtn already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignVtnToDiscExcContIEEEDEC1AEvent(
            command.getDiscExcContIEEEDEC1AId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVtnFromDiscExcContIEEEDEC1ACommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVtnFromDiscExcContIEEEDEC1ACommand");

    if (vtn == null) throw new ProcessingException("Vtn already has nothing assigned.");

    apply(new UnAssignVtnFromDiscExcContIEEEDEC1AEvent(command.getDiscExcContIEEEDEC1AId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("Event sourcing CreateDiscExcContIEEEDEC1AEvent");
    this.discExcContIEEEDEC1AId = event.getDiscExcContIEEEDEC1AId();
  }

  @EventSourcingHandler
  void on(UpdateDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.esc = event.getEsc();
    this.kan = event.getKan();
    this.ketl = event.getKetl();
    this.tan = event.getTan();
    this.td = event.getTd();
    this.tl1 = event.getTl1();
    this.tl2 = event.getTl2();
    this.tw5 = event.getTw5();
    this.value = event.getValue();
    this.vanmax = event.getVanmax();
    this.vomax = event.getVomax();
    this.vomin = event.getVomin();
    this.vsmax = event.getVsmax();
    this.vsmin = event.getVsmin();
    this.vtc = event.getVtc();
    this.vtlmt = event.getVtlmt();
    this.vtm = event.getVtm();
    this.vtn = event.getVtn();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignEscToDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("Event sourcing AssignEscToDiscExcContIEEEDEC1AEvent");
    this.esc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEscFromDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignEscFromDiscExcContIEEEDEC1AEvent");
    this.esc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKanToDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("Event sourcing AssignKanToDiscExcContIEEEDEC1AEvent");
    this.kan = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKanFromDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignKanFromDiscExcContIEEEDEC1AEvent");
    this.kan = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKetlToDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("Event sourcing AssignKetlToDiscExcContIEEEDEC1AEvent");
    this.ketl = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKetlFromDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignKetlFromDiscExcContIEEEDEC1AEvent");
    this.ketl = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTanToDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("Event sourcing AssignTanToDiscExcContIEEEDEC1AEvent");
    this.tan = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTanFromDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignTanFromDiscExcContIEEEDEC1AEvent");
    this.tan = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTdToDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("Event sourcing AssignTdToDiscExcContIEEEDEC1AEvent");
    this.td = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTdFromDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignTdFromDiscExcContIEEEDEC1AEvent");
    this.td = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTl1ToDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("Event sourcing AssignTl1ToDiscExcContIEEEDEC1AEvent");
    this.tl1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTl1FromDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignTl1FromDiscExcContIEEEDEC1AEvent");
    this.tl1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTl2ToDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("Event sourcing AssignTl2ToDiscExcContIEEEDEC1AEvent");
    this.tl2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTl2FromDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignTl2FromDiscExcContIEEEDEC1AEvent");
    this.tl2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTw5ToDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("Event sourcing AssignTw5ToDiscExcContIEEEDEC1AEvent");
    this.tw5 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTw5FromDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignTw5FromDiscExcContIEEEDEC1AEvent");
    this.tw5 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignValueToDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("Event sourcing AssignValueToDiscExcContIEEEDEC1AEvent");
    this.value = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignValueFromDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignValueFromDiscExcContIEEEDEC1AEvent");
    this.value = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVanmaxToDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("Event sourcing AssignVanmaxToDiscExcContIEEEDEC1AEvent");
    this.vanmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVanmaxFromDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignVanmaxFromDiscExcContIEEEDEC1AEvent");
    this.vanmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVomaxToDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("Event sourcing AssignVomaxToDiscExcContIEEEDEC1AEvent");
    this.vomax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVomaxFromDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignVomaxFromDiscExcContIEEEDEC1AEvent");
    this.vomax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVominToDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("Event sourcing AssignVominToDiscExcContIEEEDEC1AEvent");
    this.vomin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVominFromDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignVominFromDiscExcContIEEEDEC1AEvent");
    this.vomin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVsmaxToDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("Event sourcing AssignVsmaxToDiscExcContIEEEDEC1AEvent");
    this.vsmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVsmaxFromDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignVsmaxFromDiscExcContIEEEDEC1AEvent");
    this.vsmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVsminToDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("Event sourcing AssignVsminToDiscExcContIEEEDEC1AEvent");
    this.vsmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVsminFromDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignVsminFromDiscExcContIEEEDEC1AEvent");
    this.vsmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVtcToDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("Event sourcing AssignVtcToDiscExcContIEEEDEC1AEvent");
    this.vtc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVtcFromDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignVtcFromDiscExcContIEEEDEC1AEvent");
    this.vtc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVtlmtToDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("Event sourcing AssignVtlmtToDiscExcContIEEEDEC1AEvent");
    this.vtlmt = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVtlmtFromDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignVtlmtFromDiscExcContIEEEDEC1AEvent");
    this.vtlmt = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVtmToDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("Event sourcing AssignVtmToDiscExcContIEEEDEC1AEvent");
    this.vtm = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVtmFromDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignVtmFromDiscExcContIEEEDEC1AEvent");
    this.vtm = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVtnToDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("Event sourcing AssignVtnToDiscExcContIEEEDEC1AEvent");
    this.vtn = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVtnFromDiscExcContIEEEDEC1AEvent event) {
    LOGGER.info("Event sourcing UnAssignVtnFromDiscExcContIEEEDEC1AEvent");
    this.vtn = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID discExcContIEEEDEC1AId;

  private PU esc = null;
  private PU kan = null;
  private PU ketl = null;
  private Seconds tan = null;
  private Seconds td = null;
  private Seconds tl1 = null;
  private Seconds tl2 = null;
  private Seconds tw5 = null;
  private PU value = null;
  private PU vanmax = null;
  private PU vomax = null;
  private PU vomin = null;
  private PU vsmax = null;
  private PU vsmin = null;
  private PU vtc = null;
  private PU vtlmt = null;
  private PU vtm = null;
  private PU vtn = null;

  private static final Logger LOGGER =
      Logger.getLogger(DiscExcContIEEEDEC1AAggregate.class.getName());
}
