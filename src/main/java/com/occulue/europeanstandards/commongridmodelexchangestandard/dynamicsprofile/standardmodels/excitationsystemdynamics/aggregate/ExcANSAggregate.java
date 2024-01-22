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
 * Aggregate handler for ExcANS as outlined for the CQRS pattern, all write responsibilities related
 * to ExcANS are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ExcANSAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ExcANSAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ExcANSAggregate(CreateExcANSCommand command) throws Exception {
    LOGGER.info("Handling command CreateExcANSCommand");
    CreateExcANSEvent event = new CreateExcANSEvent(command.getExcANSId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateExcANSCommand command) throws Exception {
    LOGGER.info("handling command UpdateExcANSCommand");
    UpdateExcANSEvent event =
        new UpdateExcANSEvent(
            command.getExcANSId(),
            command.getBlint(),
            command.getIfmn(),
            command.getIfmx(),
            command.getK2(),
            command.getK3(),
            command.getKce(),
            command.getKrvecc(),
            command.getKvfif(),
            command.getT1(),
            command.getT2(),
            command.getT3(),
            command.getTb(),
            command.getVrmn(),
            command.getVrmx());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteExcANSCommand command) throws Exception {
    LOGGER.info("Handling command DeleteExcANSCommand");
    apply(new DeleteExcANSEvent(command.getExcANSId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignBlintToExcANSCommand command) throws Exception {
    LOGGER.info("Handling command AssignBlintToExcANSCommand");

    if (blint != null && blint.getIntegerProxyId() == command.getAssignment().getIntegerProxyId())
      throw new ProcessingException(
          "Blint already assigned with id " + command.getAssignment().getIntegerProxyId());

    apply(new AssignBlintToExcANSEvent(command.getExcANSId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignBlintFromExcANSCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignBlintFromExcANSCommand");

    if (blint == null) throw new ProcessingException("Blint already has nothing assigned.");

    apply(new UnAssignBlintFromExcANSEvent(command.getExcANSId()));
  }

  @CommandHandler
  public void handle(AssignIfmnToExcANSCommand command) throws Exception {
    LOGGER.info("Handling command AssignIfmnToExcANSCommand");

    if (ifmn != null && ifmn.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ifmn already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignIfmnToExcANSEvent(command.getExcANSId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignIfmnFromExcANSCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignIfmnFromExcANSCommand");

    if (ifmn == null) throw new ProcessingException("Ifmn already has nothing assigned.");

    apply(new UnAssignIfmnFromExcANSEvent(command.getExcANSId()));
  }

  @CommandHandler
  public void handle(AssignIfmxToExcANSCommand command) throws Exception {
    LOGGER.info("Handling command AssignIfmxToExcANSCommand");

    if (ifmx != null && ifmx.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Ifmx already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignIfmxToExcANSEvent(command.getExcANSId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignIfmxFromExcANSCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignIfmxFromExcANSCommand");

    if (ifmx == null) throw new ProcessingException("Ifmx already has nothing assigned.");

    apply(new UnAssignIfmxFromExcANSEvent(command.getExcANSId()));
  }

  @CommandHandler
  public void handle(AssignK2ToExcANSCommand command) throws Exception {
    LOGGER.info("Handling command AssignK2ToExcANSCommand");

    if (k2 != null && k2.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "K2 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignK2ToExcANSEvent(command.getExcANSId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignK2FromExcANSCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignK2FromExcANSCommand");

    if (k2 == null) throw new ProcessingException("K2 already has nothing assigned.");

    apply(new UnAssignK2FromExcANSEvent(command.getExcANSId()));
  }

  @CommandHandler
  public void handle(AssignK3ToExcANSCommand command) throws Exception {
    LOGGER.info("Handling command AssignK3ToExcANSCommand");

    if (k3 != null && k3.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "K3 already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignK3ToExcANSEvent(command.getExcANSId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignK3FromExcANSCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignK3FromExcANSCommand");

    if (k3 == null) throw new ProcessingException("K3 already has nothing assigned.");

    apply(new UnAssignK3FromExcANSEvent(command.getExcANSId()));
  }

  @CommandHandler
  public void handle(AssignKceToExcANSCommand command) throws Exception {
    LOGGER.info("Handling command AssignKceToExcANSCommand");

    if (kce != null && kce.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Kce already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(new AssignKceToExcANSEvent(command.getExcANSId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKceFromExcANSCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKceFromExcANSCommand");

    if (kce == null) throw new ProcessingException("Kce already has nothing assigned.");

    apply(new UnAssignKceFromExcANSEvent(command.getExcANSId()));
  }

  @CommandHandler
  public void handle(AssignKrveccToExcANSCommand command) throws Exception {
    LOGGER.info("Handling command AssignKrveccToExcANSCommand");

    if (krvecc != null && krvecc.getIntegerProxyId() == command.getAssignment().getIntegerProxyId())
      throw new ProcessingException(
          "Krvecc already assigned with id " + command.getAssignment().getIntegerProxyId());

    apply(new AssignKrveccToExcANSEvent(command.getExcANSId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKrveccFromExcANSCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKrveccFromExcANSCommand");

    if (krvecc == null) throw new ProcessingException("Krvecc already has nothing assigned.");

    apply(new UnAssignKrveccFromExcANSEvent(command.getExcANSId()));
  }

  @CommandHandler
  public void handle(AssignKvfifToExcANSCommand command) throws Exception {
    LOGGER.info("Handling command AssignKvfifToExcANSCommand");

    if (kvfif != null && kvfif.getIntegerProxyId() == command.getAssignment().getIntegerProxyId())
      throw new ProcessingException(
          "Kvfif already assigned with id " + command.getAssignment().getIntegerProxyId());

    apply(new AssignKvfifToExcANSEvent(command.getExcANSId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKvfifFromExcANSCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKvfifFromExcANSCommand");

    if (kvfif == null) throw new ProcessingException("Kvfif already has nothing assigned.");

    apply(new UnAssignKvfifFromExcANSEvent(command.getExcANSId()));
  }

  @CommandHandler
  public void handle(AssignT1ToExcANSCommand command) throws Exception {
    LOGGER.info("Handling command AssignT1ToExcANSCommand");

    if (t1 != null && t1.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T1 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT1ToExcANSEvent(command.getExcANSId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT1FromExcANSCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT1FromExcANSCommand");

    if (t1 == null) throw new ProcessingException("T1 already has nothing assigned.");

    apply(new UnAssignT1FromExcANSEvent(command.getExcANSId()));
  }

  @CommandHandler
  public void handle(AssignT2ToExcANSCommand command) throws Exception {
    LOGGER.info("Handling command AssignT2ToExcANSCommand");

    if (t2 != null && t2.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T2 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT2ToExcANSEvent(command.getExcANSId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT2FromExcANSCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT2FromExcANSCommand");

    if (t2 == null) throw new ProcessingException("T2 already has nothing assigned.");

    apply(new UnAssignT2FromExcANSEvent(command.getExcANSId()));
  }

  @CommandHandler
  public void handle(AssignT3ToExcANSCommand command) throws Exception {
    LOGGER.info("Handling command AssignT3ToExcANSCommand");

    if (t3 != null && t3.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T3 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignT3ToExcANSEvent(command.getExcANSId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT3FromExcANSCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT3FromExcANSCommand");

    if (t3 == null) throw new ProcessingException("T3 already has nothing assigned.");

    apply(new UnAssignT3FromExcANSEvent(command.getExcANSId()));
  }

  @CommandHandler
  public void handle(AssignTbToExcANSCommand command) throws Exception {
    LOGGER.info("Handling command AssignTbToExcANSCommand");

    if (tb != null && tb.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tb already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTbToExcANSEvent(command.getExcANSId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTbFromExcANSCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTbFromExcANSCommand");

    if (tb == null) throw new ProcessingException("Tb already has nothing assigned.");

    apply(new UnAssignTbFromExcANSEvent(command.getExcANSId()));
  }

  @CommandHandler
  public void handle(AssignVrmnToExcANSCommand command) throws Exception {
    LOGGER.info("Handling command AssignVrmnToExcANSCommand");

    if (vrmn != null && vrmn.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmn already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrmnToExcANSEvent(command.getExcANSId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrmnFromExcANSCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrmnFromExcANSCommand");

    if (vrmn == null) throw new ProcessingException("Vrmn already has nothing assigned.");

    apply(new UnAssignVrmnFromExcANSEvent(command.getExcANSId()));
  }

  @CommandHandler
  public void handle(AssignVrmxToExcANSCommand command) throws Exception {
    LOGGER.info("Handling command AssignVrmxToExcANSCommand");

    if (vrmx != null && vrmx.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Vrmx already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignVrmxToExcANSEvent(command.getExcANSId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignVrmxFromExcANSCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignVrmxFromExcANSCommand");

    if (vrmx == null) throw new ProcessingException("Vrmx already has nothing assigned.");

    apply(new UnAssignVrmxFromExcANSEvent(command.getExcANSId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateExcANSEvent event) {
    LOGGER.info("Event sourcing CreateExcANSEvent");
    this.excANSId = event.getExcANSId();
  }

  @EventSourcingHandler
  void on(UpdateExcANSEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.blint = event.getBlint();
    this.ifmn = event.getIfmn();
    this.ifmx = event.getIfmx();
    this.k2 = event.getK2();
    this.k3 = event.getK3();
    this.kce = event.getKce();
    this.krvecc = event.getKrvecc();
    this.kvfif = event.getKvfif();
    this.t1 = event.getT1();
    this.t2 = event.getT2();
    this.t3 = event.getT3();
    this.tb = event.getTb();
    this.vrmn = event.getVrmn();
    this.vrmx = event.getVrmx();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignBlintToExcANSEvent event) {
    LOGGER.info("Event sourcing AssignBlintToExcANSEvent");
    this.blint = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignBlintFromExcANSEvent event) {
    LOGGER.info("Event sourcing UnAssignBlintFromExcANSEvent");
    this.blint = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignIfmnToExcANSEvent event) {
    LOGGER.info("Event sourcing AssignIfmnToExcANSEvent");
    this.ifmn = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignIfmnFromExcANSEvent event) {
    LOGGER.info("Event sourcing UnAssignIfmnFromExcANSEvent");
    this.ifmn = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignIfmxToExcANSEvent event) {
    LOGGER.info("Event sourcing AssignIfmxToExcANSEvent");
    this.ifmx = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignIfmxFromExcANSEvent event) {
    LOGGER.info("Event sourcing UnAssignIfmxFromExcANSEvent");
    this.ifmx = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignK2ToExcANSEvent event) {
    LOGGER.info("Event sourcing AssignK2ToExcANSEvent");
    this.k2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignK2FromExcANSEvent event) {
    LOGGER.info("Event sourcing UnAssignK2FromExcANSEvent");
    this.k2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignK3ToExcANSEvent event) {
    LOGGER.info("Event sourcing AssignK3ToExcANSEvent");
    this.k3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignK3FromExcANSEvent event) {
    LOGGER.info("Event sourcing UnAssignK3FromExcANSEvent");
    this.k3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKceToExcANSEvent event) {
    LOGGER.info("Event sourcing AssignKceToExcANSEvent");
    this.kce = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKceFromExcANSEvent event) {
    LOGGER.info("Event sourcing UnAssignKceFromExcANSEvent");
    this.kce = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKrveccToExcANSEvent event) {
    LOGGER.info("Event sourcing AssignKrveccToExcANSEvent");
    this.krvecc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKrveccFromExcANSEvent event) {
    LOGGER.info("Event sourcing UnAssignKrveccFromExcANSEvent");
    this.krvecc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKvfifToExcANSEvent event) {
    LOGGER.info("Event sourcing AssignKvfifToExcANSEvent");
    this.kvfif = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKvfifFromExcANSEvent event) {
    LOGGER.info("Event sourcing UnAssignKvfifFromExcANSEvent");
    this.kvfif = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT1ToExcANSEvent event) {
    LOGGER.info("Event sourcing AssignT1ToExcANSEvent");
    this.t1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT1FromExcANSEvent event) {
    LOGGER.info("Event sourcing UnAssignT1FromExcANSEvent");
    this.t1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT2ToExcANSEvent event) {
    LOGGER.info("Event sourcing AssignT2ToExcANSEvent");
    this.t2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT2FromExcANSEvent event) {
    LOGGER.info("Event sourcing UnAssignT2FromExcANSEvent");
    this.t2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT3ToExcANSEvent event) {
    LOGGER.info("Event sourcing AssignT3ToExcANSEvent");
    this.t3 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT3FromExcANSEvent event) {
    LOGGER.info("Event sourcing UnAssignT3FromExcANSEvent");
    this.t3 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTbToExcANSEvent event) {
    LOGGER.info("Event sourcing AssignTbToExcANSEvent");
    this.tb = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTbFromExcANSEvent event) {
    LOGGER.info("Event sourcing UnAssignTbFromExcANSEvent");
    this.tb = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrmnToExcANSEvent event) {
    LOGGER.info("Event sourcing AssignVrmnToExcANSEvent");
    this.vrmn = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrmnFromExcANSEvent event) {
    LOGGER.info("Event sourcing UnAssignVrmnFromExcANSEvent");
    this.vrmn = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignVrmxToExcANSEvent event) {
    LOGGER.info("Event sourcing AssignVrmxToExcANSEvent");
    this.vrmx = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignVrmxFromExcANSEvent event) {
    LOGGER.info("Event sourcing UnAssignVrmxFromExcANSEvent");
    this.vrmx = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID excANSId;

  private IntegerProxy blint = null;
  private PU ifmn = null;
  private PU ifmx = null;
  private Simple_Float k2 = null;
  private Simple_Float k3 = null;
  private Simple_Float kce = null;
  private IntegerProxy krvecc = null;
  private IntegerProxy kvfif = null;
  private Seconds t1 = null;
  private Seconds t2 = null;
  private Seconds t3 = null;
  private Seconds tb = null;
  private PU vrmn = null;
  private PU vrmx = null;

  private static final Logger LOGGER = Logger.getLogger(ExcANSAggregate.class.getName());
}
