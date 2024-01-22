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
 * Aggregate handler for WindPitchContEmulIEC as outlined for the CQRS pattern, all write
 * responsibilities related to WindPitchContEmulIEC are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class WindPitchContEmulIECAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public WindPitchContEmulIECAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public WindPitchContEmulIECAggregate(CreateWindPitchContEmulIECCommand command) throws Exception {
    LOGGER.info("Handling command CreateWindPitchContEmulIECCommand");
    CreateWindPitchContEmulIECEvent event =
        new CreateWindPitchContEmulIECEvent(command.getWindPitchContEmulIECId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateWindPitchContEmulIECCommand command) throws Exception {
    LOGGER.info("handling command UpdateWindPitchContEmulIECCommand");
    UpdateWindPitchContEmulIECEvent event =
        new UpdateWindPitchContEmulIECEvent(
            command.getWindPitchContEmulIECId(),
            command.getKdroop(),
            command.getKipce(),
            command.getKomegaaero(),
            command.getKppce(),
            command.getOmegaref(),
            command.getPimax(),
            command.getPimin(),
            command.getT1(),
            command.getT2(),
            command.getTpe());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteWindPitchContEmulIECCommand command) throws Exception {
    LOGGER.info("Handling command DeleteWindPitchContEmulIECCommand");
    apply(new DeleteWindPitchContEmulIECEvent(command.getWindPitchContEmulIECId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignKdroopToWindPitchContEmulIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignKdroopToWindPitchContEmulIECCommand");

    if (kdroop != null && kdroop.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Kdroop already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignKdroopToWindPitchContEmulIECEvent(
            command.getWindPitchContEmulIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKdroopFromWindPitchContEmulIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKdroopFromWindPitchContEmulIECCommand");

    if (kdroop == null) throw new ProcessingException("Kdroop already has nothing assigned.");

    apply(new UnAssignKdroopFromWindPitchContEmulIECEvent(command.getWindPitchContEmulIECId()));
  }

  @CommandHandler
  public void handle(AssignKipceToWindPitchContEmulIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignKipceToWindPitchContEmulIECCommand");

    if (kipce != null && kipce.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Kipce already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignKipceToWindPitchContEmulIECEvent(
            command.getWindPitchContEmulIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKipceFromWindPitchContEmulIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKipceFromWindPitchContEmulIECCommand");

    if (kipce == null) throw new ProcessingException("Kipce already has nothing assigned.");

    apply(new UnAssignKipceFromWindPitchContEmulIECEvent(command.getWindPitchContEmulIECId()));
  }

  @CommandHandler
  public void handle(AssignKomegaaeroToWindPitchContEmulIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignKomegaaeroToWindPitchContEmulIECCommand");

    if (komegaaero != null && komegaaero.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Komegaaero already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignKomegaaeroToWindPitchContEmulIECEvent(
            command.getWindPitchContEmulIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKomegaaeroFromWindPitchContEmulIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKomegaaeroFromWindPitchContEmulIECCommand");

    if (komegaaero == null)
      throw new ProcessingException("Komegaaero already has nothing assigned.");

    apply(new UnAssignKomegaaeroFromWindPitchContEmulIECEvent(command.getWindPitchContEmulIECId()));
  }

  @CommandHandler
  public void handle(AssignKppceToWindPitchContEmulIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignKppceToWindPitchContEmulIECCommand");

    if (kppce != null && kppce.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Kppce already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignKppceToWindPitchContEmulIECEvent(
            command.getWindPitchContEmulIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKppceFromWindPitchContEmulIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignKppceFromWindPitchContEmulIECCommand");

    if (kppce == null) throw new ProcessingException("Kppce already has nothing assigned.");

    apply(new UnAssignKppceFromWindPitchContEmulIECEvent(command.getWindPitchContEmulIECId()));
  }

  @CommandHandler
  public void handle(AssignOmegarefToWindPitchContEmulIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignOmegarefToWindPitchContEmulIECCommand");

    if (omegaref != null && omegaref.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Omegaref already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignOmegarefToWindPitchContEmulIECEvent(
            command.getWindPitchContEmulIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignOmegarefFromWindPitchContEmulIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignOmegarefFromWindPitchContEmulIECCommand");

    if (omegaref == null) throw new ProcessingException("Omegaref already has nothing assigned.");

    apply(new UnAssignOmegarefFromWindPitchContEmulIECEvent(command.getWindPitchContEmulIECId()));
  }

  @CommandHandler
  public void handle(AssignPimaxToWindPitchContEmulIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignPimaxToWindPitchContEmulIECCommand");

    if (pimax != null && pimax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pimax already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignPimaxToWindPitchContEmulIECEvent(
            command.getWindPitchContEmulIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPimaxFromWindPitchContEmulIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPimaxFromWindPitchContEmulIECCommand");

    if (pimax == null) throw new ProcessingException("Pimax already has nothing assigned.");

    apply(new UnAssignPimaxFromWindPitchContEmulIECEvent(command.getWindPitchContEmulIECId()));
  }

  @CommandHandler
  public void handle(AssignPiminToWindPitchContEmulIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignPiminToWindPitchContEmulIECCommand");

    if (pimin != null && pimin.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Pimin already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignPiminToWindPitchContEmulIECEvent(
            command.getWindPitchContEmulIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPiminFromWindPitchContEmulIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPiminFromWindPitchContEmulIECCommand");

    if (pimin == null) throw new ProcessingException("Pimin already has nothing assigned.");

    apply(new UnAssignPiminFromWindPitchContEmulIECEvent(command.getWindPitchContEmulIECId()));
  }

  @CommandHandler
  public void handle(AssignT1ToWindPitchContEmulIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignT1ToWindPitchContEmulIECCommand");

    if (t1 != null && t1.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T1 already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignT1ToWindPitchContEmulIECEvent(
            command.getWindPitchContEmulIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT1FromWindPitchContEmulIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT1FromWindPitchContEmulIECCommand");

    if (t1 == null) throw new ProcessingException("T1 already has nothing assigned.");

    apply(new UnAssignT1FromWindPitchContEmulIECEvent(command.getWindPitchContEmulIECId()));
  }

  @CommandHandler
  public void handle(AssignT2ToWindPitchContEmulIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignT2ToWindPitchContEmulIECCommand");

    if (t2 != null && t2.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "T2 already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignT2ToWindPitchContEmulIECEvent(
            command.getWindPitchContEmulIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignT2FromWindPitchContEmulIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignT2FromWindPitchContEmulIECCommand");

    if (t2 == null) throw new ProcessingException("T2 already has nothing assigned.");

    apply(new UnAssignT2FromWindPitchContEmulIECEvent(command.getWindPitchContEmulIECId()));
  }

  @CommandHandler
  public void handle(AssignTpeToWindPitchContEmulIECCommand command) throws Exception {
    LOGGER.info("Handling command AssignTpeToWindPitchContEmulIECCommand");

    if (tpe != null && tpe.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tpe already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTpeToWindPitchContEmulIECEvent(
            command.getWindPitchContEmulIECId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTpeFromWindPitchContEmulIECCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignTpeFromWindPitchContEmulIECCommand");

    if (tpe == null) throw new ProcessingException("Tpe already has nothing assigned.");

    apply(new UnAssignTpeFromWindPitchContEmulIECEvent(command.getWindPitchContEmulIECId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateWindPitchContEmulIECEvent event) {
    LOGGER.info("Event sourcing CreateWindPitchContEmulIECEvent");
    this.windPitchContEmulIECId = event.getWindPitchContEmulIECId();
  }

  @EventSourcingHandler
  void on(UpdateWindPitchContEmulIECEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.kdroop = event.getKdroop();
    this.kipce = event.getKipce();
    this.komegaaero = event.getKomegaaero();
    this.kppce = event.getKppce();
    this.omegaref = event.getOmegaref();
    this.pimax = event.getPimax();
    this.pimin = event.getPimin();
    this.t1 = event.getT1();
    this.t2 = event.getT2();
    this.tpe = event.getTpe();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignKdroopToWindPitchContEmulIECEvent event) {
    LOGGER.info("Event sourcing AssignKdroopToWindPitchContEmulIECEvent");
    this.kdroop = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKdroopFromWindPitchContEmulIECEvent event) {
    LOGGER.info("Event sourcing UnAssignKdroopFromWindPitchContEmulIECEvent");
    this.kdroop = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKipceToWindPitchContEmulIECEvent event) {
    LOGGER.info("Event sourcing AssignKipceToWindPitchContEmulIECEvent");
    this.kipce = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKipceFromWindPitchContEmulIECEvent event) {
    LOGGER.info("Event sourcing UnAssignKipceFromWindPitchContEmulIECEvent");
    this.kipce = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKomegaaeroToWindPitchContEmulIECEvent event) {
    LOGGER.info("Event sourcing AssignKomegaaeroToWindPitchContEmulIECEvent");
    this.komegaaero = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKomegaaeroFromWindPitchContEmulIECEvent event) {
    LOGGER.info("Event sourcing UnAssignKomegaaeroFromWindPitchContEmulIECEvent");
    this.komegaaero = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKppceToWindPitchContEmulIECEvent event) {
    LOGGER.info("Event sourcing AssignKppceToWindPitchContEmulIECEvent");
    this.kppce = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKppceFromWindPitchContEmulIECEvent event) {
    LOGGER.info("Event sourcing UnAssignKppceFromWindPitchContEmulIECEvent");
    this.kppce = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignOmegarefToWindPitchContEmulIECEvent event) {
    LOGGER.info("Event sourcing AssignOmegarefToWindPitchContEmulIECEvent");
    this.omegaref = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignOmegarefFromWindPitchContEmulIECEvent event) {
    LOGGER.info("Event sourcing UnAssignOmegarefFromWindPitchContEmulIECEvent");
    this.omegaref = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPimaxToWindPitchContEmulIECEvent event) {
    LOGGER.info("Event sourcing AssignPimaxToWindPitchContEmulIECEvent");
    this.pimax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPimaxFromWindPitchContEmulIECEvent event) {
    LOGGER.info("Event sourcing UnAssignPimaxFromWindPitchContEmulIECEvent");
    this.pimax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignPiminToWindPitchContEmulIECEvent event) {
    LOGGER.info("Event sourcing AssignPiminToWindPitchContEmulIECEvent");
    this.pimin = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPiminFromWindPitchContEmulIECEvent event) {
    LOGGER.info("Event sourcing UnAssignPiminFromWindPitchContEmulIECEvent");
    this.pimin = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT1ToWindPitchContEmulIECEvent event) {
    LOGGER.info("Event sourcing AssignT1ToWindPitchContEmulIECEvent");
    this.t1 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT1FromWindPitchContEmulIECEvent event) {
    LOGGER.info("Event sourcing UnAssignT1FromWindPitchContEmulIECEvent");
    this.t1 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignT2ToWindPitchContEmulIECEvent event) {
    LOGGER.info("Event sourcing AssignT2ToWindPitchContEmulIECEvent");
    this.t2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignT2FromWindPitchContEmulIECEvent event) {
    LOGGER.info("Event sourcing UnAssignT2FromWindPitchContEmulIECEvent");
    this.t2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTpeToWindPitchContEmulIECEvent event) {
    LOGGER.info("Event sourcing AssignTpeToWindPitchContEmulIECEvent");
    this.tpe = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTpeFromWindPitchContEmulIECEvent event) {
    LOGGER.info("Event sourcing UnAssignTpeFromWindPitchContEmulIECEvent");
    this.tpe = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID windPitchContEmulIECId;

  private Simple_Float kdroop = null;
  private Simple_Float kipce = null;
  private PU komegaaero = null;
  private Simple_Float kppce = null;
  private PU omegaref = null;
  private PU pimax = null;
  private PU pimin = null;
  private Seconds t1 = null;
  private Seconds t2 = null;
  private Seconds tpe = null;

  private static final Logger LOGGER =
      Logger.getLogger(WindPitchContEmulIECAggregate.class.getName());
}
