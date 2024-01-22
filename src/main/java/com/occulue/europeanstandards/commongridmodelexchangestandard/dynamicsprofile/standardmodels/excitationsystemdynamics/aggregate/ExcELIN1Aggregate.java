package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.excitationsystemdynamics.aggregate;

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
 * Aggregate handler for ExcELIN1 as outlined for the CQRS pattern, all write responsibilities
 * related to ExcELIN1 are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ExcELIN1Aggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ExcELIN1Aggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ExcELIN1Aggregate(CreateExcELIN1Command command) throws Exception {
    LOGGER.info("Handling command CreateExcELIN1Command");
    CreateExcELIN1Event event = new CreateExcELIN1Event(command.getExcELIN1Id());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateExcELIN1Command command) throws Exception {
    LOGGER.info("handling command UpdateExcELIN1Command");
    UpdateExcELIN1Event event =
        new UpdateExcELIN1Event(
            command.getExcELIN1Id(),
            command.getDpnf(),
            command.getEfmax(),
            command.getEfmin(),
            command.getKs1(),
            command.getKs2(),
            command.getSmax(),
            command.getTfi(),
            command.getTnu(),
            command.getTs1(),
            command.getTs2(),
            command.getTsw(),
            command.getVpi(),
            command.getVpnf(),
            command.getVpu(),
            command.getXe());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteExcELIN1Command command) throws Exception {
    LOGGER.info("Handling command DeleteExcELIN1Command");
    apply(new DeleteExcELIN1Event(command.getExcELIN1Id()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignDpnfToExcELIN1Command command) throws Exception {
    LOGGER.info("Handling command AssignDpnfToExcELIN1Command");

    if (dpnf != null && dpnf.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Dpnf already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignDpnfToExcELIN1Event(command.getExcELIN1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDpnfFromExcELIN1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignDpnfFromExcELIN1Command");

    if (dpnf == null) throw new ProcessingException("Dpnf already has nothing assigned.");

    apply(new UnAssignDpnfFromExcELIN1Event(command.getExcELIN1Id()));
  }

  @CommandHandler
  public void handle(AssignEfmaxToExcELIN1Command command) throws Exception {
    LOGGER.info("Handling command AssignEfmaxToExcELIN1Command");

    if (efmax != null && efmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Efmax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignEfmaxToExcELIN1Event(command.getExcELIN1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEfmaxFromExcELIN1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignEfmaxFromExcELIN1Command");

    if (efmax == null) throw new ProcessingException("Efmax already has nothing assigned.");

    apply(new UnAssignEfmaxFromExcELIN1Event(command.getExcELIN1Id()));
  }

  @CommandHandler
  public void handle(AssignEfminToExcELIN1Command command) throws Exception {
    LOGGER.info("Handling command AssignEfminToExcELIN1Command");

    if (efmin != null && efmin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Efmin already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignEfminToExcELIN1Event(command.getExcELIN1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEfminFromExcELIN1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignEfminFromExcELIN1Command");

    if (efmin == null) throw new ProcessingException("Efmin already has nothing assigned.");

    apply(new UnAssignEfminFromExcELIN1Event(command.getExcELIN1Id()));
  }

  @CommandHandler
  public void handle(AssignKs1ToExcELIN1Command command) throws Exception {
    LOGGER.info("Handling command AssignKs1ToExcELIN1Command");

    if (ks1 != null && ks1.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ks1 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKs1ToExcELIN1Event(command.getExcELIN1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKs1FromExcELIN1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKs1FromExcELIN1Command");

    if (ks1 == null) throw new ProcessingException("Ks1 already has nothing assigned.");

    apply(new UnAssignKs1FromExcELIN1Event(command.getExcELIN1Id()));
  }

  @CommandHandler
  public void handle(AssignKs2ToExcELIN1Command command) throws Exception {
    LOGGER.info("Handling command AssignKs2ToExcELIN1Command");

    if (ks2 != null && ks2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ks2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKs2ToExcELIN1Event(command.getExcELIN1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKs2FromExcELIN1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKs2FromExcELIN1Command");

    if (ks2 == null) throw new ProcessingException("Ks2 already has nothing assigned.");

    apply(new UnAssignKs2FromExcELIN1Event(command.getExcELIN1Id()));
  }

  @CommandHandler
  public void handle(AssignSmaxToExcELIN1Command command) throws Exception {
    LOGGER.info("Handling command AssignSmaxToExcELIN1Command");

    if (smax != null && smax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Smax already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignSmaxToExcELIN1Event(command.getExcELIN1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSmaxFromExcELIN1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignSmaxFromExcELIN1Command");

    if (smax == null) throw new ProcessingException("Smax already has nothing assigned.");

    apply(new UnAssignSmaxFromExcELIN1Event(command.getExcELIN1Id()));
  }

  @CommandHandler
  public void handle(AssignTfiToExcELIN1Command command) throws Exception {
    LOGGER.info("Handling command AssignTfiToExcELIN1Command");

    if (tfi != null && tfi.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tfi already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTfiToExcELIN1Event(command.getExcELIN1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTfiFromExcELIN1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTfiFromExcELIN1Command");

    if (tfi == null) throw new ProcessingException("Tfi already has nothing assigned.");

    apply(new UnAssignTfiFromExcELIN1Event(command.getExcELIN1Id()));
  }

  @CommandHandler
  public void handle(AssignTnuToExcELIN1Command command) throws Exception {
    LOGGER.info("Handling command AssignTnuToExcELIN1Command");

    if (tnu != null && tnu.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tnu already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTnuToExcELIN1Event(command.getExcELIN1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTnuFromExcELIN1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTnuFromExcELIN1Command");

    if (tnu == null) throw new ProcessingException("Tnu already has nothing assigned.");

    apply(new UnAssignTnuFromExcELIN1Event(command.getExcELIN1Id()));
  }

  @CommandHandler
  public void handle(AssignTs1ToExcELIN1Command command) throws Exception {
    LOGGER.info("Handling command AssignTs1ToExcELIN1Command");

    if (ts1 != null && ts1.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ts1 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTs1ToExcELIN1Event(command.getExcELIN1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTs1FromExcELIN1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTs1FromExcELIN1Command");

    if (ts1 == null) throw new ProcessingException("Ts1 already has nothing assigned.");

    apply(new UnAssignTs1FromExcELIN1Event(command.getExcELIN1Id()));
  }

  @CommandHandler
  public void handle(AssignTs2ToExcELIN1Command command) throws Exception {
    LOGGER.info("Handling command AssignTs2ToExcELIN1Command");

    if (ts2 != null && ts2.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Ts2 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTs2ToExcELIN1Event(command.getExcELIN1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTs2FromExcELIN1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTs2FromExcELIN1Command");

    if (ts2 == null) throw new ProcessingException("Ts2 already has nothing assigned.");

    apply(new UnAssignTs2FromExcELIN1Event(command.getExcELIN1Id()));
  }

  @CommandHandler
  public void handle(AssignTswToExcELIN1Command command) throws Exception {
    LOGGER.info("Handling command AssignTswToExcELIN1Command");

    if (tsw != null && tsw.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tsw already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTswToExcELIN1Event(command.getExcELIN1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTswFromExcELIN1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTswFromExcELIN1Command");

    if (tsw == null) throw new ProcessingException("Tsw already has nothing assigned.");

    apply(new UnAssignTswFromExcELIN1Event(command.getExcELIN1Id()));
  }

  @CommandHandler
  public void handle(AssignVpiToExcELIN1Command command) throws Exception {
    LOGGER.info("Handling command AssignVpiToExcELIN1Command");

    if (vpi != null && vpi.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vpi already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVpiToExcELIN1Event(command.getExcELIN1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVpiFromExcELIN1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignVpiFromExcELIN1Command");

    if (vpi == null) throw new ProcessingException("Vpi already has nothing assigned.");

    apply(new UnAssignVpiFromExcELIN1Event(command.getExcELIN1Id()));
  }

  @CommandHandler
  public void handle(AssignVpnfToExcELIN1Command command) throws Exception {
    LOGGER.info("Handling command AssignVpnfToExcELIN1Command");

    if (vpnf != null && vpnf.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vpnf already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVpnfToExcELIN1Event(command.getExcELIN1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVpnfFromExcELIN1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignVpnfFromExcELIN1Command");

    if (vpnf == null) throw new ProcessingException("Vpnf already has nothing assigned.");

    apply(new UnAssignVpnfFromExcELIN1Event(command.getExcELIN1Id()));
  }

  @CommandHandler
  public void handle(AssignVpuToExcELIN1Command command) throws Exception {
    LOGGER.info("Handling command AssignVpuToExcELIN1Command");

    if (vpu != null && vpu.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vpu already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVpuToExcELIN1Event(command.getExcELIN1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVpuFromExcELIN1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignVpuFromExcELIN1Command");

    if (vpu == null) throw new ProcessingException("Vpu already has nothing assigned.");

    apply(new UnAssignVpuFromExcELIN1Event(command.getExcELIN1Id()));
  }

  @CommandHandler
  public void handle(AssignXeToExcELIN1Command command) throws Exception {
    LOGGER.info("Handling command AssignXeToExcELIN1Command");

    if (xe != null && xe.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Xe already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignXeToExcELIN1Event(command.getExcELIN1Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignXeFromExcELIN1Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignXeFromExcELIN1Command");

    if (xe == null) throw new ProcessingException("Xe already has nothing assigned.");

    apply(new UnAssignXeFromExcELIN1Event(command.getExcELIN1Id()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateExcELIN1Event event) {
    LOGGER.info("Event sourcing CreateExcELIN1Event");
    this.excELIN1Id = event.getExcELIN1Id();
  }

  @EventSourcingHandler
  void on(UpdateExcELIN1Event event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.dpnf = event.getDpnf();
    this.efmax = event.getEfmax();
    this.efmin = event.getEfmin();
    this.ks1 = event.getKs1();
    this.ks2 = event.getKs2();
    this.smax = event.getSmax();
    this.tfi = event.getTfi();
    this.tnu = event.getTnu();
    this.ts1 = event.getTs1();
    this.ts2 = event.getTs2();
    this.tsw = event.getTsw();
    this.vpi = event.getVpi();
    this.vpnf = event.getVpnf();
    this.vpu = event.getVpu();
    this.xe = event.getXe();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignDpnfToExcELIN1Event event) {
    LOGGER.info("Event sourcing AssignDpnfToExcELIN1Event");
    this.dpnf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDpnfFromExcELIN1Event event) {
    LOGGER.info("Event sourcing UnAssignDpnfFromExcELIN1Event");
    this.dpnf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEfmaxToExcELIN1Event event) {
    LOGGER.info("Event sourcing AssignEfmaxToExcELIN1Event");
    this.efmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEfmaxFromExcELIN1Event event) {
    LOGGER.info("Event sourcing UnAssignEfmaxFromExcELIN1Event");
    this.efmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEfminToExcELIN1Event event) {
    LOGGER.info("Event sourcing AssignEfminToExcELIN1Event");
    this.efmin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEfminFromExcELIN1Event event) {
    LOGGER.info("Event sourcing UnAssignEfminFromExcELIN1Event");
    this.efmin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKs1ToExcELIN1Event event) {
    LOGGER.info("Event sourcing AssignKs1ToExcELIN1Event");
    this.ks1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKs1FromExcELIN1Event event) {
    LOGGER.info("Event sourcing UnAssignKs1FromExcELIN1Event");
    this.ks1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKs2ToExcELIN1Event event) {
    LOGGER.info("Event sourcing AssignKs2ToExcELIN1Event");
    this.ks2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKs2FromExcELIN1Event event) {
    LOGGER.info("Event sourcing UnAssignKs2FromExcELIN1Event");
    this.ks2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSmaxToExcELIN1Event event) {
    LOGGER.info("Event sourcing AssignSmaxToExcELIN1Event");
    this.smax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSmaxFromExcELIN1Event event) {
    LOGGER.info("Event sourcing UnAssignSmaxFromExcELIN1Event");
    this.smax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTfiToExcELIN1Event event) {
    LOGGER.info("Event sourcing AssignTfiToExcELIN1Event");
    this.tfi = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTfiFromExcELIN1Event event) {
    LOGGER.info("Event sourcing UnAssignTfiFromExcELIN1Event");
    this.tfi = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTnuToExcELIN1Event event) {
    LOGGER.info("Event sourcing AssignTnuToExcELIN1Event");
    this.tnu = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTnuFromExcELIN1Event event) {
    LOGGER.info("Event sourcing UnAssignTnuFromExcELIN1Event");
    this.tnu = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTs1ToExcELIN1Event event) {
    LOGGER.info("Event sourcing AssignTs1ToExcELIN1Event");
    this.ts1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTs1FromExcELIN1Event event) {
    LOGGER.info("Event sourcing UnAssignTs1FromExcELIN1Event");
    this.ts1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTs2ToExcELIN1Event event) {
    LOGGER.info("Event sourcing AssignTs2ToExcELIN1Event");
    this.ts2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTs2FromExcELIN1Event event) {
    LOGGER.info("Event sourcing UnAssignTs2FromExcELIN1Event");
    this.ts2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTswToExcELIN1Event event) {
    LOGGER.info("Event sourcing AssignTswToExcELIN1Event");
    this.tsw = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTswFromExcELIN1Event event) {
    LOGGER.info("Event sourcing UnAssignTswFromExcELIN1Event");
    this.tsw = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVpiToExcELIN1Event event) {
    LOGGER.info("Event sourcing AssignVpiToExcELIN1Event");
    this.vpi = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVpiFromExcELIN1Event event) {
    LOGGER.info("Event sourcing UnAssignVpiFromExcELIN1Event");
    this.vpi = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVpnfToExcELIN1Event event) {
    LOGGER.info("Event sourcing AssignVpnfToExcELIN1Event");
    this.vpnf = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVpnfFromExcELIN1Event event) {
    LOGGER.info("Event sourcing UnAssignVpnfFromExcELIN1Event");
    this.vpnf = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVpuToExcELIN1Event event) {
    LOGGER.info("Event sourcing AssignVpuToExcELIN1Event");
    this.vpu = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVpuFromExcELIN1Event event) {
    LOGGER.info("Event sourcing UnAssignVpuFromExcELIN1Event");
    this.vpu = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignXeToExcELIN1Event event) {
    LOGGER.info("Event sourcing AssignXeToExcELIN1Event");
    this.xe = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignXeFromExcELIN1Event event) {
    LOGGER.info("Event sourcing UnAssignXeFromExcELIN1Event");
    this.xe = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID excELIN1Id;

  private PU dpnf = null;
  private PU efmax = null;
  private PU efmin = null;
  private PU ks1 = null;
  private PU ks2 = null;
  private PU smax = null;
  private Seconds tfi = null;
  private Seconds tnu = null;
  private Seconds ts1 = null;
  private Seconds ts2 = null;
  private Seconds tsw = null;
  private PU vpi = null;
  private PU vpnf = null;
  private PU vpu = null;
  private PU xe = null;

  private static final Logger LOGGER = Logger.getLogger(ExcELIN1Aggregate.class.getName());
}
