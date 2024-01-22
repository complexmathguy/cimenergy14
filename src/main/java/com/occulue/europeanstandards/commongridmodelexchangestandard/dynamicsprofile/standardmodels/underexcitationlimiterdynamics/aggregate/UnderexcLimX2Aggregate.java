package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.underexcitationlimiterdynamics.aggregate;

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
 * Aggregate handler for UnderexcLimX2 as outlined for the CQRS pattern, all write responsibilities
 * related to UnderexcLimX2 are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class UnderexcLimX2Aggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public UnderexcLimX2Aggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public UnderexcLimX2Aggregate(CreateUnderexcLimX2Command command) throws Exception {
    LOGGER.info("Handling command CreateUnderexcLimX2Command");
    CreateUnderexcLimX2Event event = new CreateUnderexcLimX2Event(command.getUnderexcLimX2Id());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateUnderexcLimX2Command command) throws Exception {
    LOGGER.info("handling command UpdateUnderexcLimX2Command");
    UpdateUnderexcLimX2Event event =
        new UpdateUnderexcLimX2Event(
            command.getUnderexcLimX2Id(),
            command.getKf2(),
            command.getKm(),
            command.getMelmax(),
            command.getQo(),
            command.getR(),
            command.getTf2(),
            command.getTm());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteUnderexcLimX2Command command) throws Exception {
    LOGGER.info("Handling command DeleteUnderexcLimX2Command");
    apply(new DeleteUnderexcLimX2Event(command.getUnderexcLimX2Id()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignKf2ToUnderexcLimX2Command command) throws Exception {
    LOGGER.info("Handling command AssignKf2ToUnderexcLimX2Command");

    if (kf2 != null && kf2.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Kf2 already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKf2ToUnderexcLimX2Event(command.getUnderexcLimX2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKf2FromUnderexcLimX2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKf2FromUnderexcLimX2Command");

    if (kf2 == null) throw new ProcessingException("Kf2 already has nothing assigned.");

    apply(new UnAssignKf2FromUnderexcLimX2Event(command.getUnderexcLimX2Id()));
  }

  @CommandHandler
  public void handle(AssignKmToUnderexcLimX2Command command) throws Exception {
    LOGGER.info("Handling command AssignKmToUnderexcLimX2Command");

    if (km != null && km.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Km already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignKmToUnderexcLimX2Event(command.getUnderexcLimX2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKmFromUnderexcLimX2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignKmFromUnderexcLimX2Command");

    if (km == null) throw new ProcessingException("Km already has nothing assigned.");

    apply(new UnAssignKmFromUnderexcLimX2Event(command.getUnderexcLimX2Id()));
  }

  @CommandHandler
  public void handle(AssignMelmaxToUnderexcLimX2Command command) throws Exception {
    LOGGER.info("Handling command AssignMelmaxToUnderexcLimX2Command");

    if (melmax != null && melmax.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Melmax already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignMelmaxToUnderexcLimX2Event(
            command.getUnderexcLimX2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignMelmaxFromUnderexcLimX2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignMelmaxFromUnderexcLimX2Command");

    if (melmax == null) throw new ProcessingException("Melmax already has nothing assigned.");

    apply(new UnAssignMelmaxFromUnderexcLimX2Event(command.getUnderexcLimX2Id()));
  }

  @CommandHandler
  public void handle(AssignQoToUnderexcLimX2Command command) throws Exception {
    LOGGER.info("Handling command AssignQoToUnderexcLimX2Command");

    if (qo != null && qo.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "Qo already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignQoToUnderexcLimX2Event(command.getUnderexcLimX2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignQoFromUnderexcLimX2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignQoFromUnderexcLimX2Command");

    if (qo == null) throw new ProcessingException("Qo already has nothing assigned.");

    apply(new UnAssignQoFromUnderexcLimX2Event(command.getUnderexcLimX2Id()));
  }

  @CommandHandler
  public void handle(AssignRToUnderexcLimX2Command command) throws Exception {
    LOGGER.info("Handling command AssignRToUnderexcLimX2Command");

    if (r != null && r.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "R already assigned with id " + command.getAssignment().getPUId());

    apply(new AssignRToUnderexcLimX2Event(command.getUnderexcLimX2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignRFromUnderexcLimX2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignRFromUnderexcLimX2Command");

    if (r == null) throw new ProcessingException("R already has nothing assigned.");

    apply(new UnAssignRFromUnderexcLimX2Event(command.getUnderexcLimX2Id()));
  }

  @CommandHandler
  public void handle(AssignTf2ToUnderexcLimX2Command command) throws Exception {
    LOGGER.info("Handling command AssignTf2ToUnderexcLimX2Command");

    if (tf2 != null && tf2.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tf2 already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTf2ToUnderexcLimX2Event(command.getUnderexcLimX2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTf2FromUnderexcLimX2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTf2FromUnderexcLimX2Command");

    if (tf2 == null) throw new ProcessingException("Tf2 already has nothing assigned.");

    apply(new UnAssignTf2FromUnderexcLimX2Event(command.getUnderexcLimX2Id()));
  }

  @CommandHandler
  public void handle(AssignTmToUnderexcLimX2Command command) throws Exception {
    LOGGER.info("Handling command AssignTmToUnderexcLimX2Command");

    if (tm != null && tm.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tm already assigned with id " + command.getAssignment().getSecondsId());

    apply(new AssignTmToUnderexcLimX2Event(command.getUnderexcLimX2Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTmFromUnderexcLimX2Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTmFromUnderexcLimX2Command");

    if (tm == null) throw new ProcessingException("Tm already has nothing assigned.");

    apply(new UnAssignTmFromUnderexcLimX2Event(command.getUnderexcLimX2Id()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateUnderexcLimX2Event event) {
    LOGGER.info("Event sourcing CreateUnderexcLimX2Event");
    this.underexcLimX2Id = event.getUnderexcLimX2Id();
  }

  @EventSourcingHandler
  void on(UpdateUnderexcLimX2Event event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.kf2 = event.getKf2();
    this.km = event.getKm();
    this.melmax = event.getMelmax();
    this.qo = event.getQo();
    this.r = event.getR();
    this.tf2 = event.getTf2();
    this.tm = event.getTm();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignKf2ToUnderexcLimX2Event event) {
    LOGGER.info("Event sourcing AssignKf2ToUnderexcLimX2Event");
    this.kf2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKf2FromUnderexcLimX2Event event) {
    LOGGER.info("Event sourcing UnAssignKf2FromUnderexcLimX2Event");
    this.kf2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignKmToUnderexcLimX2Event event) {
    LOGGER.info("Event sourcing AssignKmToUnderexcLimX2Event");
    this.km = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKmFromUnderexcLimX2Event event) {
    LOGGER.info("Event sourcing UnAssignKmFromUnderexcLimX2Event");
    this.km = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignMelmaxToUnderexcLimX2Event event) {
    LOGGER.info("Event sourcing AssignMelmaxToUnderexcLimX2Event");
    this.melmax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignMelmaxFromUnderexcLimX2Event event) {
    LOGGER.info("Event sourcing UnAssignMelmaxFromUnderexcLimX2Event");
    this.melmax = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignQoToUnderexcLimX2Event event) {
    LOGGER.info("Event sourcing AssignQoToUnderexcLimX2Event");
    this.qo = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignQoFromUnderexcLimX2Event event) {
    LOGGER.info("Event sourcing UnAssignQoFromUnderexcLimX2Event");
    this.qo = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignRToUnderexcLimX2Event event) {
    LOGGER.info("Event sourcing AssignRToUnderexcLimX2Event");
    this.r = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignRFromUnderexcLimX2Event event) {
    LOGGER.info("Event sourcing UnAssignRFromUnderexcLimX2Event");
    this.r = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTf2ToUnderexcLimX2Event event) {
    LOGGER.info("Event sourcing AssignTf2ToUnderexcLimX2Event");
    this.tf2 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTf2FromUnderexcLimX2Event event) {
    LOGGER.info("Event sourcing UnAssignTf2FromUnderexcLimX2Event");
    this.tf2 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTmToUnderexcLimX2Event event) {
    LOGGER.info("Event sourcing AssignTmToUnderexcLimX2Event");
    this.tm = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTmFromUnderexcLimX2Event event) {
    LOGGER.info("Event sourcing UnAssignTmFromUnderexcLimX2Event");
    this.tm = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID underexcLimX2Id;

  private PU kf2 = null;
  private PU km = null;
  private PU melmax = null;
  private PU qo = null;
  private PU r = null;
  private Seconds tf2 = null;
  private Seconds tm = null;

  private static final Logger LOGGER = Logger.getLogger(UnderexcLimX2Aggregate.class.getName());
}
