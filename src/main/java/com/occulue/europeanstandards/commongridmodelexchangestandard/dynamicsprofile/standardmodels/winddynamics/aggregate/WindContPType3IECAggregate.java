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
 * Aggregate handler for WindContPType3IEC as outlined for the CQRS pattern, all write
 * responsibilities related to WindContPType3IEC are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class WindContPType3IECAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public WindContPType3IECAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public WindContPType3IECAggregate(CreateWindContPType3IECCommand command) throws Exception {
    LOGGER.info("Handling command CreateWindContPType3IECCommand");
    CreateWindContPType3IECEvent event =
        new CreateWindContPType3IECEvent(command.getWindContPType3IECId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateWindContPType3IECCommand command) throws Exception {
    LOGGER.info("handling command UpdateWindContPType3IECCommand");
    UpdateWindContPType3IECEvent event =
        new UpdateWindContPType3IECEvent(
            command.getWindContPType3IECId(),
            command.getDpmax(),
            command.getDtrisemaxlvrt(),
            command.getKdtd(),
            command.getKip(),
            command.getKpp(),
            command.getMplvrt(),
            command.getOmegaoffset(),
            command.getPdtdmax(),
            command.getRramp(),
            command.getTdvs(),
            command.getTemin(),
            command.getTomegafilt(),
            command.getTpfilt(),
            command.getTpord(),
            command.getTufilt(),
            command.getTuscale(),
            command.getTwref(),
            command.getUdvs(),
            command.getUpdip(),
            command.getWdtd(),
            command.getZeta());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteWindContPType3IECCommand command) throws Exception {
    LOGGER.info("Handling command DeleteWindContPType3IECCommand");
    apply(new DeleteWindContPType3IECEvent(command.getWindContPType3IECId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignDpmaxToWindContPType3IECCommand command) throws Exception {
    LOGGER.info("Handling command AssignDpmaxToWindContPType3IECCommand");

    if (dpmax != null && dpmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Dpmax already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignDpmaxToWindContPType3IECEvent(
            command.getWindContPType3IECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDpmaxFromWindContPType3IECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignDpmaxFromWindContPType3IECCommand");

    if (dpmax == null) throw new ProcessingException("Dpmax already has nothing assigned.");

    apply(new UnAssignDpmaxFromWindContPType3IECEvent(command.getWindContPType3IECId()));
  }

  @CommandHandler
  public void handle(AssignDtrisemaxlvrtToWindContPType3IECCommand command) throws Exception {
    LOGGER.info("Handling command AssignDtrisemaxlvrtToWindContPType3IECCommand");

    if (dtrisemaxlvrt != null && dtrisemaxlvrt.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Dtrisemaxlvrt already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignDtrisemaxlvrtToWindContPType3IECEvent(
            command.getWindContPType3IECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDtrisemaxlvrtFromWindContPType3IECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignDtrisemaxlvrtFromWindContPType3IECCommand");

    if (dtrisemaxlvrt == null)
      throw new ProcessingException("Dtrisemaxlvrt already has nothing assigned.");

    apply(new UnAssignDtrisemaxlvrtFromWindContPType3IECEvent(command.getWindContPType3IECId()));
  }

  @CommandHandler
  public void handle(AssignKdtdToWindContPType3IECCommand command) throws Exception {
    LOGGER.info("Handling command AssignKdtdToWindContPType3IECCommand");

    if (kdtd != null && kdtd.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kdtd already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignKdtdToWindContPType3IECEvent(
            command.getWindContPType3IECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKdtdFromWindContPType3IECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKdtdFromWindContPType3IECCommand");

    if (kdtd == null) throw new ProcessingException("Kdtd already has nothing assigned.");

    apply(new UnAssignKdtdFromWindContPType3IECEvent(command.getWindContPType3IECId()));
  }

  @CommandHandler
  public void handle(AssignKipToWindContPType3IECCommand command) throws Exception {
    LOGGER.info("Handling command AssignKipToWindContPType3IECCommand");

    if (kip != null && kip.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kip already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignKipToWindContPType3IECEvent(
            command.getWindContPType3IECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKipFromWindContPType3IECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKipFromWindContPType3IECCommand");

    if (kip == null) throw new ProcessingException("Kip already has nothing assigned.");

    apply(new UnAssignKipFromWindContPType3IECEvent(command.getWindContPType3IECId()));
  }

  @CommandHandler
  public void handle(AssignKppToWindContPType3IECCommand command) throws Exception {
    LOGGER.info("Handling command AssignKppToWindContPType3IECCommand");

    if (kpp != null && kpp.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kpp already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignKppToWindContPType3IECEvent(
            command.getWindContPType3IECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKppFromWindContPType3IECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKppFromWindContPType3IECCommand");

    if (kpp == null) throw new ProcessingException("Kpp already has nothing assigned.");

    apply(new UnAssignKppFromWindContPType3IECEvent(command.getWindContPType3IECId()));
  }

  @CommandHandler
  public void handle(AssignMplvrtToWindContPType3IECCommand command) throws Exception {
    LOGGER.info("Handling command AssignMplvrtToWindContPType3IECCommand");

    if (mplvrt != null && mplvrt.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Mplvrt already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(
        new AssignMplvrtToWindContPType3IECEvent(
            command.getWindContPType3IECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMplvrtFromWindContPType3IECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignMplvrtFromWindContPType3IECCommand");

    if (mplvrt == null) throw new ProcessingException("Mplvrt already has nothing assigned.");

    apply(new UnAssignMplvrtFromWindContPType3IECEvent(command.getWindContPType3IECId()));
  }

  @CommandHandler
  public void handle(AssignOmegaoffsetToWindContPType3IECCommand command) throws Exception {
    LOGGER.info("Handling command AssignOmegaoffsetToWindContPType3IECCommand");

    if (omegaoffset != null && omegaoffset.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Omegaoffset already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignOmegaoffsetToWindContPType3IECEvent(
            command.getWindContPType3IECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignOmegaoffsetFromWindContPType3IECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignOmegaoffsetFromWindContPType3IECCommand");

    if (omegaoffset == null)
      throw new ProcessingException("Omegaoffset already has nothing assigned.");

    apply(new UnAssignOmegaoffsetFromWindContPType3IECEvent(command.getWindContPType3IECId()));
  }

  @CommandHandler
  public void handle(AssignPdtdmaxToWindContPType3IECCommand command) throws Exception {
    LOGGER.info("Handling command AssignPdtdmaxToWindContPType3IECCommand");

    if (pdtdmax != null && pdtdmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pdtdmax already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignPdtdmaxToWindContPType3IECEvent(
            command.getWindContPType3IECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPdtdmaxFromWindContPType3IECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPdtdmaxFromWindContPType3IECCommand");

    if (pdtdmax == null) throw new ProcessingException("Pdtdmax already has nothing assigned.");

    apply(new UnAssignPdtdmaxFromWindContPType3IECEvent(command.getWindContPType3IECId()));
  }

  @CommandHandler
  public void handle(AssignRrampToWindContPType3IECCommand command) throws Exception {
    LOGGER.info("Handling command AssignRrampToWindContPType3IECCommand");

    if (rramp != null && rramp.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Rramp already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignRrampToWindContPType3IECEvent(
            command.getWindContPType3IECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRrampFromWindContPType3IECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignRrampFromWindContPType3IECCommand");

    if (rramp == null) throw new ProcessingException("Rramp already has nothing assigned.");

    apply(new UnAssignRrampFromWindContPType3IECEvent(command.getWindContPType3IECId()));
  }

  @CommandHandler
  public void handle(AssignTdvsToWindContPType3IECCommand command) throws Exception {
    LOGGER.info("Handling command AssignTdvsToWindContPType3IECCommand");

    if (tdvs != null && tdvs.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tdvs already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTdvsToWindContPType3IECEvent(
            command.getWindContPType3IECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTdvsFromWindContPType3IECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTdvsFromWindContPType3IECCommand");

    if (tdvs == null) throw new ProcessingException("Tdvs already has nothing assigned.");

    apply(new UnAssignTdvsFromWindContPType3IECEvent(command.getWindContPType3IECId()));
  }

  @CommandHandler
  public void handle(AssignTeminToWindContPType3IECCommand command) throws Exception {
    LOGGER.info("Handling command AssignTeminToWindContPType3IECCommand");

    if (temin != null && temin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Temin already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignTeminToWindContPType3IECEvent(
            command.getWindContPType3IECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTeminFromWindContPType3IECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTeminFromWindContPType3IECCommand");

    if (temin == null) throw new ProcessingException("Temin already has nothing assigned.");

    apply(new UnAssignTeminFromWindContPType3IECEvent(command.getWindContPType3IECId()));
  }

  @CommandHandler
  public void handle(AssignTomegafiltToWindContPType3IECCommand command) throws Exception {
    LOGGER.info("Handling command AssignTomegafiltToWindContPType3IECCommand");

    if (tomegafilt != null && tomegafilt.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tomegafilt already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTomegafiltToWindContPType3IECEvent(
            command.getWindContPType3IECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTomegafiltFromWindContPType3IECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTomegafiltFromWindContPType3IECCommand");

    if (tomegafilt == null)
      throw new ProcessingException("Tomegafilt already has nothing assigned.");

    apply(new UnAssignTomegafiltFromWindContPType3IECEvent(command.getWindContPType3IECId()));
  }

  @CommandHandler
  public void handle(AssignTpfiltToWindContPType3IECCommand command) throws Exception {
    LOGGER.info("Handling command AssignTpfiltToWindContPType3IECCommand");

    if (tpfilt != null && tpfilt.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tpfilt already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTpfiltToWindContPType3IECEvent(
            command.getWindContPType3IECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTpfiltFromWindContPType3IECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTpfiltFromWindContPType3IECCommand");

    if (tpfilt == null) throw new ProcessingException("Tpfilt already has nothing assigned.");

    apply(new UnAssignTpfiltFromWindContPType3IECEvent(command.getWindContPType3IECId()));
  }

  @CommandHandler
  public void handle(AssignTpordToWindContPType3IECCommand command) throws Exception {
    LOGGER.info("Handling command AssignTpordToWindContPType3IECCommand");

    if (tpord != null && tpord.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Tpord already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignTpordToWindContPType3IECEvent(
            command.getWindContPType3IECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTpordFromWindContPType3IECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTpordFromWindContPType3IECCommand");

    if (tpord == null) throw new ProcessingException("Tpord already has nothing assigned.");

    apply(new UnAssignTpordFromWindContPType3IECEvent(command.getWindContPType3IECId()));
  }

  @CommandHandler
  public void handle(AssignTufiltToWindContPType3IECCommand command) throws Exception {
    LOGGER.info("Handling command AssignTufiltToWindContPType3IECCommand");

    if (tufilt != null && tufilt.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tufilt already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTufiltToWindContPType3IECEvent(
            command.getWindContPType3IECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTufiltFromWindContPType3IECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTufiltFromWindContPType3IECCommand");

    if (tufilt == null) throw new ProcessingException("Tufilt already has nothing assigned.");

    apply(new UnAssignTufiltFromWindContPType3IECEvent(command.getWindContPType3IECId()));
  }

  @CommandHandler
  public void handle(AssignTuscaleToWindContPType3IECCommand command) throws Exception {
    LOGGER.info("Handling command AssignTuscaleToWindContPType3IECCommand");

    if (tuscale != null && tuscale.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Tuscale already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignTuscaleToWindContPType3IECEvent(
            command.getWindContPType3IECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTuscaleFromWindContPType3IECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTuscaleFromWindContPType3IECCommand");

    if (tuscale == null) throw new ProcessingException("Tuscale already has nothing assigned.");

    apply(new UnAssignTuscaleFromWindContPType3IECEvent(command.getWindContPType3IECId()));
  }

  @CommandHandler
  public void handle(AssignTwrefToWindContPType3IECCommand command) throws Exception {
    LOGGER.info("Handling command AssignTwrefToWindContPType3IECCommand");

    if (twref != null && twref.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Twref already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTwrefToWindContPType3IECEvent(
            command.getWindContPType3IECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTwrefFromWindContPType3IECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTwrefFromWindContPType3IECCommand");

    if (twref == null) throw new ProcessingException("Twref already has nothing assigned.");

    apply(new UnAssignTwrefFromWindContPType3IECEvent(command.getWindContPType3IECId()));
  }

  @CommandHandler
  public void handle(AssignUdvsToWindContPType3IECCommand command) throws Exception {
    LOGGER.info("Handling command AssignUdvsToWindContPType3IECCommand");

    if (udvs != null && udvs.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Udvs already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignUdvsToWindContPType3IECEvent(
            command.getWindContPType3IECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignUdvsFromWindContPType3IECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignUdvsFromWindContPType3IECCommand");

    if (udvs == null) throw new ProcessingException("Udvs already has nothing assigned.");

    apply(new UnAssignUdvsFromWindContPType3IECEvent(command.getWindContPType3IECId()));
  }

  @CommandHandler
  public void handle(AssignUpdipToWindContPType3IECCommand command) throws Exception {
    LOGGER.info("Handling command AssignUpdipToWindContPType3IECCommand");

    if (updip != null && updip.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Updip already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignUpdipToWindContPType3IECEvent(
            command.getWindContPType3IECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignUpdipFromWindContPType3IECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignUpdipFromWindContPType3IECCommand");

    if (updip == null) throw new ProcessingException("Updip already has nothing assigned.");

    apply(new UnAssignUpdipFromWindContPType3IECEvent(command.getWindContPType3IECId()));
  }

  @CommandHandler
  public void handle(AssignWdtdToWindContPType3IECCommand command) throws Exception {
    LOGGER.info("Handling command AssignWdtdToWindContPType3IECCommand");

    if (wdtd != null && wdtd.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Wdtd already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignWdtdToWindContPType3IECEvent(
            command.getWindContPType3IECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignWdtdFromWindContPType3IECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignWdtdFromWindContPType3IECCommand");

    if (wdtd == null) throw new ProcessingException("Wdtd already has nothing assigned.");

    apply(new UnAssignWdtdFromWindContPType3IECEvent(command.getWindContPType3IECId()));
  }

  @CommandHandler
  public void handle(AssignZetaToWindContPType3IECCommand command) throws Exception {
    LOGGER.info("Handling command AssignZetaToWindContPType3IECCommand");

    if (zeta != null && zeta.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Zeta already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignZetaToWindContPType3IECEvent(
            command.getWindContPType3IECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignZetaFromWindContPType3IECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignZetaFromWindContPType3IECCommand");

    if (zeta == null) throw new ProcessingException("Zeta already has nothing assigned.");

    apply(new UnAssignZetaFromWindContPType3IECEvent(command.getWindContPType3IECId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateWindContPType3IECEvent event) {
    LOGGER.info("Event sourcing CreateWindContPType3IECEvent");
    this.windContPType3IECId = event.getWindContPType3IECId();
  }

  @EventSourcingHandler
  void on(UpdateWindContPType3IECEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.dpmax = event.getDpmax();
    this.dtrisemaxlvrt = event.getDtrisemaxlvrt();
    this.kdtd = event.getKdtd();
    this.kip = event.getKip();
    this.kpp = event.getKpp();
    this.mplvrt = event.getMplvrt();
    this.omegaoffset = event.getOmegaoffset();
    this.pdtdmax = event.getPdtdmax();
    this.rramp = event.getRramp();
    this.tdvs = event.getTdvs();
    this.temin = event.getTemin();
    this.tomegafilt = event.getTomegafilt();
    this.tpfilt = event.getTpfilt();
    this.tpord = event.getTpord();
    this.tufilt = event.getTufilt();
    this.tuscale = event.getTuscale();
    this.twref = event.getTwref();
    this.udvs = event.getUdvs();
    this.updip = event.getUpdip();
    this.wdtd = event.getWdtd();
    this.zeta = event.getZeta();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignDpmaxToWindContPType3IECEvent event) {
    LOGGER.info("Event sourcing AssignDpmaxToWindContPType3IECEvent");
    this.dpmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDpmaxFromWindContPType3IECEvent event) {
    LOGGER.info("Event sourcing UnAssignDpmaxFromWindContPType3IECEvent");
    this.dpmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDtrisemaxlvrtToWindContPType3IECEvent event) {
    LOGGER.info("Event sourcing AssignDtrisemaxlvrtToWindContPType3IECEvent");
    this.dtrisemaxlvrt = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDtrisemaxlvrtFromWindContPType3IECEvent event) {
    LOGGER.info("Event sourcing UnAssignDtrisemaxlvrtFromWindContPType3IECEvent");
    this.dtrisemaxlvrt = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKdtdToWindContPType3IECEvent event) {
    LOGGER.info("Event sourcing AssignKdtdToWindContPType3IECEvent");
    this.kdtd = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKdtdFromWindContPType3IECEvent event) {
    LOGGER.info("Event sourcing UnAssignKdtdFromWindContPType3IECEvent");
    this.kdtd = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKipToWindContPType3IECEvent event) {
    LOGGER.info("Event sourcing AssignKipToWindContPType3IECEvent");
    this.kip = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKipFromWindContPType3IECEvent event) {
    LOGGER.info("Event sourcing UnAssignKipFromWindContPType3IECEvent");
    this.kip = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKppToWindContPType3IECEvent event) {
    LOGGER.info("Event sourcing AssignKppToWindContPType3IECEvent");
    this.kpp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKppFromWindContPType3IECEvent event) {
    LOGGER.info("Event sourcing UnAssignKppFromWindContPType3IECEvent");
    this.kpp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMplvrtToWindContPType3IECEvent event) {
    LOGGER.info("Event sourcing AssignMplvrtToWindContPType3IECEvent");
    this.mplvrt = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMplvrtFromWindContPType3IECEvent event) {
    LOGGER.info("Event sourcing UnAssignMplvrtFromWindContPType3IECEvent");
    this.mplvrt = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignOmegaoffsetToWindContPType3IECEvent event) {
    LOGGER.info("Event sourcing AssignOmegaoffsetToWindContPType3IECEvent");
    this.omegaoffset = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignOmegaoffsetFromWindContPType3IECEvent event) {
    LOGGER.info("Event sourcing UnAssignOmegaoffsetFromWindContPType3IECEvent");
    this.omegaoffset = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPdtdmaxToWindContPType3IECEvent event) {
    LOGGER.info("Event sourcing AssignPdtdmaxToWindContPType3IECEvent");
    this.pdtdmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPdtdmaxFromWindContPType3IECEvent event) {
    LOGGER.info("Event sourcing UnAssignPdtdmaxFromWindContPType3IECEvent");
    this.pdtdmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRrampToWindContPType3IECEvent event) {
    LOGGER.info("Event sourcing AssignRrampToWindContPType3IECEvent");
    this.rramp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRrampFromWindContPType3IECEvent event) {
    LOGGER.info("Event sourcing UnAssignRrampFromWindContPType3IECEvent");
    this.rramp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTdvsToWindContPType3IECEvent event) {
    LOGGER.info("Event sourcing AssignTdvsToWindContPType3IECEvent");
    this.tdvs = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTdvsFromWindContPType3IECEvent event) {
    LOGGER.info("Event sourcing UnAssignTdvsFromWindContPType3IECEvent");
    this.tdvs = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTeminToWindContPType3IECEvent event) {
    LOGGER.info("Event sourcing AssignTeminToWindContPType3IECEvent");
    this.temin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTeminFromWindContPType3IECEvent event) {
    LOGGER.info("Event sourcing UnAssignTeminFromWindContPType3IECEvent");
    this.temin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTomegafiltToWindContPType3IECEvent event) {
    LOGGER.info("Event sourcing AssignTomegafiltToWindContPType3IECEvent");
    this.tomegafilt = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTomegafiltFromWindContPType3IECEvent event) {
    LOGGER.info("Event sourcing UnAssignTomegafiltFromWindContPType3IECEvent");
    this.tomegafilt = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTpfiltToWindContPType3IECEvent event) {
    LOGGER.info("Event sourcing AssignTpfiltToWindContPType3IECEvent");
    this.tpfilt = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTpfiltFromWindContPType3IECEvent event) {
    LOGGER.info("Event sourcing UnAssignTpfiltFromWindContPType3IECEvent");
    this.tpfilt = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTpordToWindContPType3IECEvent event) {
    LOGGER.info("Event sourcing AssignTpordToWindContPType3IECEvent");
    this.tpord = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTpordFromWindContPType3IECEvent event) {
    LOGGER.info("Event sourcing UnAssignTpordFromWindContPType3IECEvent");
    this.tpord = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTufiltToWindContPType3IECEvent event) {
    LOGGER.info("Event sourcing AssignTufiltToWindContPType3IECEvent");
    this.tufilt = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTufiltFromWindContPType3IECEvent event) {
    LOGGER.info("Event sourcing UnAssignTufiltFromWindContPType3IECEvent");
    this.tufilt = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTuscaleToWindContPType3IECEvent event) {
    LOGGER.info("Event sourcing AssignTuscaleToWindContPType3IECEvent");
    this.tuscale = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTuscaleFromWindContPType3IECEvent event) {
    LOGGER.info("Event sourcing UnAssignTuscaleFromWindContPType3IECEvent");
    this.tuscale = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTwrefToWindContPType3IECEvent event) {
    LOGGER.info("Event sourcing AssignTwrefToWindContPType3IECEvent");
    this.twref = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTwrefFromWindContPType3IECEvent event) {
    LOGGER.info("Event sourcing UnAssignTwrefFromWindContPType3IECEvent");
    this.twref = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignUdvsToWindContPType3IECEvent event) {
    LOGGER.info("Event sourcing AssignUdvsToWindContPType3IECEvent");
    this.udvs = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignUdvsFromWindContPType3IECEvent event) {
    LOGGER.info("Event sourcing UnAssignUdvsFromWindContPType3IECEvent");
    this.udvs = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignUpdipToWindContPType3IECEvent event) {
    LOGGER.info("Event sourcing AssignUpdipToWindContPType3IECEvent");
    this.updip = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignUpdipFromWindContPType3IECEvent event) {
    LOGGER.info("Event sourcing UnAssignUpdipFromWindContPType3IECEvent");
    this.updip = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignWdtdToWindContPType3IECEvent event) {
    LOGGER.info("Event sourcing AssignWdtdToWindContPType3IECEvent");
    this.wdtd = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignWdtdFromWindContPType3IECEvent event) {
    LOGGER.info("Event sourcing UnAssignWdtdFromWindContPType3IECEvent");
    this.wdtd = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignZetaToWindContPType3IECEvent event) {
    LOGGER.info("Event sourcing AssignZetaToWindContPType3IECEvent");
    this.zeta = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignZetaFromWindContPType3IECEvent event) {
    LOGGER.info("Event sourcing UnAssignZetaFromWindContPType3IECEvent");
    this.zeta = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID windContPType3IECId;

  private PU dpmax = null;
  private PU dtrisemaxlvrt = null;
  private PU kdtd = null;
  private PU kip = null;
  private PU kpp = null;
  private BooleanProxy mplvrt = null;
  private PU omegaoffset = null;
  private PU pdtdmax = null;
  private PU rramp = null;
  private Seconds tdvs = null;
  private PU temin = null;
  private Seconds tomegafilt = null;
  private Seconds tpfilt = null;
  private PU tpord = null;
  private Seconds tufilt = null;
  private PU tuscale = null;
  private Seconds twref = null;
  private PU udvs = null;
  private PU updip = null;
  private PU wdtd = null;
  private Simple_Float zeta = null;

  private static final Logger LOGGER = Logger.getLogger(WindContPType3IECAggregate.class.getName());
}
