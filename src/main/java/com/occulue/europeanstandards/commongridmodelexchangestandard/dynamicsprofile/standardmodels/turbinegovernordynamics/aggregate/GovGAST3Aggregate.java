package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.turbinegovernordynamics.aggregate;

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
 * Aggregate handler for GovGAST3 as outlined for the CQRS pattern, all write responsibilities
 * related to GovGAST3 are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class GovGAST3Aggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public GovGAST3Aggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public GovGAST3Aggregate(CreateGovGAST3Command command) throws Exception {
    LOGGER.info("Handling command CreateGovGAST3Command");
    CreateGovGAST3Event event = new CreateGovGAST3Event(command.getGovGAST3Id());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateGovGAST3Command command) throws Exception {
    LOGGER.info("handling command UpdateGovGAST3Command");
    UpdateGovGAST3Event event =
        new UpdateGovGAST3Event(
            command.getGovGAST3Id(),
            command.getBca(),
            command.getBp(),
            command.getDtc(),
            command.getKa(),
            command.getKac(),
            command.getKca(),
            command.getKsi(),
            command.getKy(),
            command.getMnef(),
            command.getMxef(),
            command.getRcmn(),
            command.getRcmx(),
            command.getTac(),
            command.getTc(),
            command.getTd(),
            command.getTfen(),
            command.getTg(),
            command.getTsi(),
            command.getTt(),
            command.getTtc(),
            command.getTy());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteGovGAST3Command command) throws Exception {
    LOGGER.info("Handling command DeleteGovGAST3Command");
    apply(new DeleteGovGAST3Event(command.getGovGAST3Id()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignBcaToGovGAST3Command command) throws Exception {
    LOGGER.info("Handling command AssignBcaToGovGAST3Command");

    if (bca != null && bca.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Bca already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignBcaToGovGAST3Event(command.getGovGAST3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignBcaFromGovGAST3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignBcaFromGovGAST3Command");

    if (bca == null) throw new ProcessingException("Bca already has nothing assigned.");

    apply(new UnAssignBcaFromGovGAST3Event(command.getGovGAST3Id()));
  }

  @CommandHandler
  public void handle(AssignBpToGovGAST3Command command) throws Exception {
    LOGGER.info("Handling command AssignBpToGovGAST3Command");

    if (bp != null && bp.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Bp already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignBpToGovGAST3Event(command.getGovGAST3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignBpFromGovGAST3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignBpFromGovGAST3Command");

    if (bp == null) throw new ProcessingException("Bp already has nothing assigned.");

    apply(new UnAssignBpFromGovGAST3Event(command.getGovGAST3Id()));
  }

  @CommandHandler
  public void handle(AssignDtcToGovGAST3Command command) throws Exception {
    LOGGER.info("Handling command AssignDtcToGovGAST3Command");

    if (dtc != null && dtc.getTemperatureId() == command.getAssignment().getTemperatureId())
      throw new ProcessingException(
          "Dtc already assigned with id " + command.getAssignment().getTemperatureId());

    apply(new AssignDtcToGovGAST3Event(command.getGovGAST3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDtcFromGovGAST3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignDtcFromGovGAST3Command");

    if (dtc == null) throw new ProcessingException("Dtc already has nothing assigned.");

    apply(new UnAssignDtcFromGovGAST3Event(command.getGovGAST3Id()));
  }

  @CommandHandler
  public void handle(AssignKaToGovGAST3Command command) throws Exception {
    LOGGER.info("Handling command AssignKaToGovGAST3Command");

    if (ka != null && ka.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ka already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKaToGovGAST3Event(command.getGovGAST3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKaFromGovGAST3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKaFromGovGAST3Command");

    if (ka == null) throw new ProcessingException("Ka already has nothing assigned.");

    apply(new UnAssignKaFromGovGAST3Event(command.getGovGAST3Id()));
  }

  @CommandHandler
  public void handle(AssignKacToGovGAST3Command command) throws Exception {
    LOGGER.info("Handling command AssignKacToGovGAST3Command");

    if (kac != null && kac.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Kac already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignKacToGovGAST3Event(command.getGovGAST3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKacFromGovGAST3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKacFromGovGAST3Command");

    if (kac == null) throw new ProcessingException("Kac already has nothing assigned.");

    apply(new UnAssignKacFromGovGAST3Event(command.getGovGAST3Id()));
  }

  @CommandHandler
  public void handle(AssignKcaToGovGAST3Command command) throws Exception {
    LOGGER.info("Handling command AssignKcaToGovGAST3Command");

    if (kca != null && kca.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Kca already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignKcaToGovGAST3Event(command.getGovGAST3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKcaFromGovGAST3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKcaFromGovGAST3Command");

    if (kca == null) throw new ProcessingException("Kca already has nothing assigned.");

    apply(new UnAssignKcaFromGovGAST3Event(command.getGovGAST3Id()));
  }

  @CommandHandler
  public void handle(AssignKsiToGovGAST3Command command) throws Exception {
    LOGGER.info("Handling command AssignKsiToGovGAST3Command");

    if (ksi != null && ksi.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Ksi already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignKsiToGovGAST3Event(command.getGovGAST3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKsiFromGovGAST3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKsiFromGovGAST3Command");

    if (ksi == null) throw new ProcessingException("Ksi already has nothing assigned.");

    apply(new UnAssignKsiFromGovGAST3Event(command.getGovGAST3Id()));
  }

  @CommandHandler
  public void handle(AssignKyToGovGAST3Command command) throws Exception {
    LOGGER.info("Handling command AssignKyToGovGAST3Command");

    if (ky != null && ky.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Ky already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignKyToGovGAST3Event(command.getGovGAST3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKyFromGovGAST3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKyFromGovGAST3Command");

    if (ky == null) throw new ProcessingException("Ky already has nothing assigned.");

    apply(new UnAssignKyFromGovGAST3Event(command.getGovGAST3Id()));
  }

  @CommandHandler
  public void handle(AssignMnefToGovGAST3Command command) throws Exception {
    LOGGER.info("Handling command AssignMnefToGovGAST3Command");

    if (mnef != null && mnef.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Mnef already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignMnefToGovGAST3Event(command.getGovGAST3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMnefFromGovGAST3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignMnefFromGovGAST3Command");

    if (mnef == null) throw new ProcessingException("Mnef already has nothing assigned.");

    apply(new UnAssignMnefFromGovGAST3Event(command.getGovGAST3Id()));
  }

  @CommandHandler
  public void handle(AssignMxefToGovGAST3Command command) throws Exception {
    LOGGER.info("Handling command AssignMxefToGovGAST3Command");

    if (mxef != null && mxef.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Mxef already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignMxefToGovGAST3Event(command.getGovGAST3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMxefFromGovGAST3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignMxefFromGovGAST3Command");

    if (mxef == null) throw new ProcessingException("Mxef already has nothing assigned.");

    apply(new UnAssignMxefFromGovGAST3Event(command.getGovGAST3Id()));
  }

  @CommandHandler
  public void handle(AssignRcmnToGovGAST3Command command) throws Exception {
    LOGGER.info("Handling command AssignRcmnToGovGAST3Command");

    if (rcmn != null && rcmn.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Rcmn already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignRcmnToGovGAST3Event(command.getGovGAST3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRcmnFromGovGAST3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignRcmnFromGovGAST3Command");

    if (rcmn == null) throw new ProcessingException("Rcmn already has nothing assigned.");

    apply(new UnAssignRcmnFromGovGAST3Event(command.getGovGAST3Id()));
  }

  @CommandHandler
  public void handle(AssignRcmxToGovGAST3Command command) throws Exception {
    LOGGER.info("Handling command AssignRcmxToGovGAST3Command");

    if (rcmx != null && rcmx.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Rcmx already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignRcmxToGovGAST3Event(command.getGovGAST3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRcmxFromGovGAST3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignRcmxFromGovGAST3Command");

    if (rcmx == null) throw new ProcessingException("Rcmx already has nothing assigned.");

    apply(new UnAssignRcmxFromGovGAST3Event(command.getGovGAST3Id()));
  }

  @CommandHandler
  public void handle(AssignTacToGovGAST3Command command) throws Exception {
    LOGGER.info("Handling command AssignTacToGovGAST3Command");

    if (tac != null && tac.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tac already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTacToGovGAST3Event(command.getGovGAST3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTacFromGovGAST3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTacFromGovGAST3Command");

    if (tac == null) throw new ProcessingException("Tac already has nothing assigned.");

    apply(new UnAssignTacFromGovGAST3Event(command.getGovGAST3Id()));
  }

  @CommandHandler
  public void handle(AssignTcToGovGAST3Command command) throws Exception {
    LOGGER.info("Handling command AssignTcToGovGAST3Command");

    if (tc != null && tc.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tc already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTcToGovGAST3Event(command.getGovGAST3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTcFromGovGAST3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTcFromGovGAST3Command");

    if (tc == null) throw new ProcessingException("Tc already has nothing assigned.");

    apply(new UnAssignTcFromGovGAST3Event(command.getGovGAST3Id()));
  }

  @CommandHandler
  public void handle(AssignTdToGovGAST3Command command) throws Exception {
    LOGGER.info("Handling command AssignTdToGovGAST3Command");

    if (td != null && td.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Td already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTdToGovGAST3Event(command.getGovGAST3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTdFromGovGAST3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTdFromGovGAST3Command");

    if (td == null) throw new ProcessingException("Td already has nothing assigned.");

    apply(new UnAssignTdFromGovGAST3Event(command.getGovGAST3Id()));
  }

  @CommandHandler
  public void handle(AssignTfenToGovGAST3Command command) throws Exception {
    LOGGER.info("Handling command AssignTfenToGovGAST3Command");

    if (tfen != null && tfen.getTemperatureId() == command.getAssignment().getTemperatureId())
      throw new ProcessingException(
          "Tfen already assigned with id " + command.getAssignment().getTemperatureId());

    apply(new AssignTfenToGovGAST3Event(command.getGovGAST3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTfenFromGovGAST3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTfenFromGovGAST3Command");

    if (tfen == null) throw new ProcessingException("Tfen already has nothing assigned.");

    apply(new UnAssignTfenFromGovGAST3Event(command.getGovGAST3Id()));
  }

  @CommandHandler
  public void handle(AssignTgToGovGAST3Command command) throws Exception {
    LOGGER.info("Handling command AssignTgToGovGAST3Command");

    if (tg != null && tg.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tg already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTgToGovGAST3Event(command.getGovGAST3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTgFromGovGAST3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTgFromGovGAST3Command");

    if (tg == null) throw new ProcessingException("Tg already has nothing assigned.");

    apply(new UnAssignTgFromGovGAST3Event(command.getGovGAST3Id()));
  }

  @CommandHandler
  public void handle(AssignTsiToGovGAST3Command command) throws Exception {
    LOGGER.info("Handling command AssignTsiToGovGAST3Command");

    if (tsi != null && tsi.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tsi already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTsiToGovGAST3Event(command.getGovGAST3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTsiFromGovGAST3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTsiFromGovGAST3Command");

    if (tsi == null) throw new ProcessingException("Tsi already has nothing assigned.");

    apply(new UnAssignTsiFromGovGAST3Event(command.getGovGAST3Id()));
  }

  @CommandHandler
  public void handle(AssignTtToGovGAST3Command command) throws Exception {
    LOGGER.info("Handling command AssignTtToGovGAST3Command");

    if (tt != null && tt.getTemperatureId() == command.getAssignment().getTemperatureId())
      throw new ProcessingException(
          "Tt already assigned with id " + command.getAssignment().getTemperatureId());

    apply(new AssignTtToGovGAST3Event(command.getGovGAST3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTtFromGovGAST3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTtFromGovGAST3Command");

    if (tt == null) throw new ProcessingException("Tt already has nothing assigned.");

    apply(new UnAssignTtFromGovGAST3Event(command.getGovGAST3Id()));
  }

  @CommandHandler
  public void handle(AssignTtcToGovGAST3Command command) throws Exception {
    LOGGER.info("Handling command AssignTtcToGovGAST3Command");

    if (ttc != null && ttc.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ttc already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTtcToGovGAST3Event(command.getGovGAST3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTtcFromGovGAST3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTtcFromGovGAST3Command");

    if (ttc == null) throw new ProcessingException("Ttc already has nothing assigned.");

    apply(new UnAssignTtcFromGovGAST3Event(command.getGovGAST3Id()));
  }

  @CommandHandler
  public void handle(AssignTyToGovGAST3Command command) throws Exception {
    LOGGER.info("Handling command AssignTyToGovGAST3Command");

    if (ty != null && ty.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ty already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTyToGovGAST3Event(command.getGovGAST3Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTyFromGovGAST3Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTyFromGovGAST3Command");

    if (ty == null) throw new ProcessingException("Ty already has nothing assigned.");

    apply(new UnAssignTyFromGovGAST3Event(command.getGovGAST3Id()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateGovGAST3Event event) {
    LOGGER.info("Event sourcing CreateGovGAST3Event");
    this.govGAST3Id = event.getGovGAST3Id();
  }

  @EventSourcingHandler
  void on(UpdateGovGAST3Event event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.bca = event.getBca();
    this.bp = event.getBp();
    this.dtc = event.getDtc();
    this.ka = event.getKa();
    this.kac = event.getKac();
    this.kca = event.getKca();
    this.ksi = event.getKsi();
    this.ky = event.getKy();
    this.mnef = event.getMnef();
    this.mxef = event.getMxef();
    this.rcmn = event.getRcmn();
    this.rcmx = event.getRcmx();
    this.tac = event.getTac();
    this.tc = event.getTc();
    this.td = event.getTd();
    this.tfen = event.getTfen();
    this.tg = event.getTg();
    this.tsi = event.getTsi();
    this.tt = event.getTt();
    this.ttc = event.getTtc();
    this.ty = event.getTy();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignBcaToGovGAST3Event event) {
    LOGGER.info("Event sourcing AssignBcaToGovGAST3Event");
    this.bca = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignBcaFromGovGAST3Event event) {
    LOGGER.info("Event sourcing UnAssignBcaFromGovGAST3Event");
    this.bca = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignBpToGovGAST3Event event) {
    LOGGER.info("Event sourcing AssignBpToGovGAST3Event");
    this.bp = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignBpFromGovGAST3Event event) {
    LOGGER.info("Event sourcing UnAssignBpFromGovGAST3Event");
    this.bp = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignDtcToGovGAST3Event event) {
    LOGGER.info("Event sourcing AssignDtcToGovGAST3Event");
    this.dtc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDtcFromGovGAST3Event event) {
    LOGGER.info("Event sourcing UnAssignDtcFromGovGAST3Event");
    this.dtc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKaToGovGAST3Event event) {
    LOGGER.info("Event sourcing AssignKaToGovGAST3Event");
    this.ka = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKaFromGovGAST3Event event) {
    LOGGER.info("Event sourcing UnAssignKaFromGovGAST3Event");
    this.ka = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKacToGovGAST3Event event) {
    LOGGER.info("Event sourcing AssignKacToGovGAST3Event");
    this.kac = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKacFromGovGAST3Event event) {
    LOGGER.info("Event sourcing UnAssignKacFromGovGAST3Event");
    this.kac = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKcaToGovGAST3Event event) {
    LOGGER.info("Event sourcing AssignKcaToGovGAST3Event");
    this.kca = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKcaFromGovGAST3Event event) {
    LOGGER.info("Event sourcing UnAssignKcaFromGovGAST3Event");
    this.kca = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKsiToGovGAST3Event event) {
    LOGGER.info("Event sourcing AssignKsiToGovGAST3Event");
    this.ksi = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKsiFromGovGAST3Event event) {
    LOGGER.info("Event sourcing UnAssignKsiFromGovGAST3Event");
    this.ksi = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKyToGovGAST3Event event) {
    LOGGER.info("Event sourcing AssignKyToGovGAST3Event");
    this.ky = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKyFromGovGAST3Event event) {
    LOGGER.info("Event sourcing UnAssignKyFromGovGAST3Event");
    this.ky = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMnefToGovGAST3Event event) {
    LOGGER.info("Event sourcing AssignMnefToGovGAST3Event");
    this.mnef = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMnefFromGovGAST3Event event) {
    LOGGER.info("Event sourcing UnAssignMnefFromGovGAST3Event");
    this.mnef = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMxefToGovGAST3Event event) {
    LOGGER.info("Event sourcing AssignMxefToGovGAST3Event");
    this.mxef = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMxefFromGovGAST3Event event) {
    LOGGER.info("Event sourcing UnAssignMxefFromGovGAST3Event");
    this.mxef = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRcmnToGovGAST3Event event) {
    LOGGER.info("Event sourcing AssignRcmnToGovGAST3Event");
    this.rcmn = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRcmnFromGovGAST3Event event) {
    LOGGER.info("Event sourcing UnAssignRcmnFromGovGAST3Event");
    this.rcmn = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRcmxToGovGAST3Event event) {
    LOGGER.info("Event sourcing AssignRcmxToGovGAST3Event");
    this.rcmx = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRcmxFromGovGAST3Event event) {
    LOGGER.info("Event sourcing UnAssignRcmxFromGovGAST3Event");
    this.rcmx = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTacToGovGAST3Event event) {
    LOGGER.info("Event sourcing AssignTacToGovGAST3Event");
    this.tac = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTacFromGovGAST3Event event) {
    LOGGER.info("Event sourcing UnAssignTacFromGovGAST3Event");
    this.tac = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTcToGovGAST3Event event) {
    LOGGER.info("Event sourcing AssignTcToGovGAST3Event");
    this.tc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTcFromGovGAST3Event event) {
    LOGGER.info("Event sourcing UnAssignTcFromGovGAST3Event");
    this.tc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTdToGovGAST3Event event) {
    LOGGER.info("Event sourcing AssignTdToGovGAST3Event");
    this.td = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTdFromGovGAST3Event event) {
    LOGGER.info("Event sourcing UnAssignTdFromGovGAST3Event");
    this.td = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTfenToGovGAST3Event event) {
    LOGGER.info("Event sourcing AssignTfenToGovGAST3Event");
    this.tfen = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTfenFromGovGAST3Event event) {
    LOGGER.info("Event sourcing UnAssignTfenFromGovGAST3Event");
    this.tfen = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTgToGovGAST3Event event) {
    LOGGER.info("Event sourcing AssignTgToGovGAST3Event");
    this.tg = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTgFromGovGAST3Event event) {
    LOGGER.info("Event sourcing UnAssignTgFromGovGAST3Event");
    this.tg = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTsiToGovGAST3Event event) {
    LOGGER.info("Event sourcing AssignTsiToGovGAST3Event");
    this.tsi = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTsiFromGovGAST3Event event) {
    LOGGER.info("Event sourcing UnAssignTsiFromGovGAST3Event");
    this.tsi = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTtToGovGAST3Event event) {
    LOGGER.info("Event sourcing AssignTtToGovGAST3Event");
    this.tt = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTtFromGovGAST3Event event) {
    LOGGER.info("Event sourcing UnAssignTtFromGovGAST3Event");
    this.tt = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTtcToGovGAST3Event event) {
    LOGGER.info("Event sourcing AssignTtcToGovGAST3Event");
    this.ttc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTtcFromGovGAST3Event event) {
    LOGGER.info("Event sourcing UnAssignTtcFromGovGAST3Event");
    this.ttc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTyToGovGAST3Event event) {
    LOGGER.info("Event sourcing AssignTyToGovGAST3Event");
    this.ty = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTyFromGovGAST3Event event) {
    LOGGER.info("Event sourcing UnAssignTyFromGovGAST3Event");
    this.ty = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID govGAST3Id;

  private Simple_Float bca = null;
  private PU bp = null;
  private Temperature dtc = null;
  private PU ka = null;
  private Simple_Float kac = null;
  private Simple_Float kca = null;
  private Simple_Float ksi = null;
  private Simple_Float ky = null;
  private PU mnef = null;
  private PU mxef = null;
  private PU rcmn = null;
  private PU rcmx = null;
  private Seconds tac = null;
  private Seconds tc = null;
  private Seconds td = null;
  private Temperature tfen = null;
  private Seconds tg = null;
  private Seconds tsi = null;
  private Temperature tt = null;
  private Seconds ttc = null;
  private Seconds ty = null;

  private static final Logger LOGGER = Logger.getLogger(GovGAST3Aggregate.class.getName());
}
