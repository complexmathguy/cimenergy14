package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.synchronousmachinedynamics.aggregate;

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
 * Aggregate handler for SynchronousMachineTimeConstantReactance as outlined for the CQRS pattern,
 * all write responsibilities related to SynchronousMachineTimeConstantReactance are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class SynchronousMachineTimeConstantReactanceAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public SynchronousMachineTimeConstantReactanceAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public SynchronousMachineTimeConstantReactanceAggregate(
      CreateSynchronousMachineTimeConstantReactanceCommand command) throws Exception {
    LOGGER.info("Handling command CreateSynchronousMachineTimeConstantReactanceCommand");
    CreateSynchronousMachineTimeConstantReactanceEvent event =
        new CreateSynchronousMachineTimeConstantReactanceEvent(
            command.getSynchronousMachineTimeConstantReactanceId(),
            command.getModelType(),
            command.getRotorType());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateSynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    LOGGER.info("handling command UpdateSynchronousMachineTimeConstantReactanceCommand");
    UpdateSynchronousMachineTimeConstantReactanceEvent event =
        new UpdateSynchronousMachineTimeConstantReactanceEvent(
            command.getSynchronousMachineTimeConstantReactanceId(),
            command.getKs(),
            command.getModelType(),
            command.getRotorType(),
            command.getTc(),
            command.getTpdo(),
            command.getTppdo(),
            command.getTppqo(),
            command.getTpqo(),
            command.getXDirectSubtrans(),
            command.getXDirectSync(),
            command.getXDirectTrans(),
            command.getXQuadSubtrans(),
            command.getXQuadSync(),
            command.getXQuadTrans());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteSynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    LOGGER.info("Handling command DeleteSynchronousMachineTimeConstantReactanceCommand");
    apply(
        new DeleteSynchronousMachineTimeConstantReactanceEvent(
            command.getSynchronousMachineTimeConstantReactanceId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignKsToSynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignKsToSynchronousMachineTimeConstantReactanceCommand");

    if (ks != null && ks.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Ks already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignKsToSynchronousMachineTimeConstantReactanceEvent(
            command.getSynchronousMachineTimeConstantReactanceId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignKsFromSynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignKsFromSynchronousMachineTimeConstantReactanceCommand");

    if (ks == null) throw new ProcessingException("Ks already has nothing assigned.");

    apply(
        new UnAssignKsFromSynchronousMachineTimeConstantReactanceEvent(
            command.getSynchronousMachineTimeConstantReactanceId()));
  }

  @CommandHandler
  public void handle(AssignTcToSynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignTcToSynchronousMachineTimeConstantReactanceCommand");

    if (tc != null && tc.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tc already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTcToSynchronousMachineTimeConstantReactanceEvent(
            command.getSynchronousMachineTimeConstantReactanceId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTcFromSynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignTcFromSynchronousMachineTimeConstantReactanceCommand");

    if (tc == null) throw new ProcessingException("Tc already has nothing assigned.");

    apply(
        new UnAssignTcFromSynchronousMachineTimeConstantReactanceEvent(
            command.getSynchronousMachineTimeConstantReactanceId()));
  }

  @CommandHandler
  public void handle(AssignTpdoToSynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignTpdoToSynchronousMachineTimeConstantReactanceCommand");

    if (tpdo != null && tpdo.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tpdo already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTpdoToSynchronousMachineTimeConstantReactanceEvent(
            command.getSynchronousMachineTimeConstantReactanceId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTpdoFromSynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignTpdoFromSynchronousMachineTimeConstantReactanceCommand");

    if (tpdo == null) throw new ProcessingException("Tpdo already has nothing assigned.");

    apply(
        new UnAssignTpdoFromSynchronousMachineTimeConstantReactanceEvent(
            command.getSynchronousMachineTimeConstantReactanceId()));
  }

  @CommandHandler
  public void handle(AssignTppdoToSynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignTppdoToSynchronousMachineTimeConstantReactanceCommand");

    if (tppdo != null && tppdo.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tppdo already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTppdoToSynchronousMachineTimeConstantReactanceEvent(
            command.getSynchronousMachineTimeConstantReactanceId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTppdoFromSynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignTppdoFromSynchronousMachineTimeConstantReactanceCommand");

    if (tppdo == null) throw new ProcessingException("Tppdo already has nothing assigned.");

    apply(
        new UnAssignTppdoFromSynchronousMachineTimeConstantReactanceEvent(
            command.getSynchronousMachineTimeConstantReactanceId()));
  }

  @CommandHandler
  public void handle(AssignTppqoToSynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignTppqoToSynchronousMachineTimeConstantReactanceCommand");

    if (tppqo != null && tppqo.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tppqo already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTppqoToSynchronousMachineTimeConstantReactanceEvent(
            command.getSynchronousMachineTimeConstantReactanceId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTppqoFromSynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignTppqoFromSynchronousMachineTimeConstantReactanceCommand");

    if (tppqo == null) throw new ProcessingException("Tppqo already has nothing assigned.");

    apply(
        new UnAssignTppqoFromSynchronousMachineTimeConstantReactanceEvent(
            command.getSynchronousMachineTimeConstantReactanceId()));
  }

  @CommandHandler
  public void handle(AssignTpqoToSynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignTpqoToSynchronousMachineTimeConstantReactanceCommand");

    if (tpqo != null && tpqo.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Tpqo already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignTpqoToSynchronousMachineTimeConstantReactanceEvent(
            command.getSynchronousMachineTimeConstantReactanceId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTpqoFromSynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignTpqoFromSynchronousMachineTimeConstantReactanceCommand");

    if (tpqo == null) throw new ProcessingException("Tpqo already has nothing assigned.");

    apply(
        new UnAssignTpqoFromSynchronousMachineTimeConstantReactanceEvent(
            command.getSynchronousMachineTimeConstantReactanceId()));
  }

  @CommandHandler
  public void handle(AssignXDirectSubtransToSynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    LOGGER.info(
        "Handling command AssignXDirectSubtransToSynchronousMachineTimeConstantReactanceCommand");

    if (xDirectSubtrans != null && xDirectSubtrans.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "XDirectSubtrans already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignXDirectSubtransToSynchronousMachineTimeConstantReactanceEvent(
            command.getSynchronousMachineTimeConstantReactanceId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(
      UnAssignXDirectSubtransFromSynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    LOGGER.info(
        "Handlign command UnAssignXDirectSubtransFromSynchronousMachineTimeConstantReactanceCommand");

    if (xDirectSubtrans == null)
      throw new ProcessingException("XDirectSubtrans already has nothing assigned.");

    apply(
        new UnAssignXDirectSubtransFromSynchronousMachineTimeConstantReactanceEvent(
            command.getSynchronousMachineTimeConstantReactanceId()));
  }

  @CommandHandler
  public void handle(AssignXDirectSyncToSynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    LOGGER.info(
        "Handling command AssignXDirectSyncToSynchronousMachineTimeConstantReactanceCommand");

    if (xDirectSync != null && xDirectSync.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "XDirectSync already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignXDirectSyncToSynchronousMachineTimeConstantReactanceEvent(
            command.getSynchronousMachineTimeConstantReactanceId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignXDirectSyncFromSynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    LOGGER.info(
        "Handlign command UnAssignXDirectSyncFromSynchronousMachineTimeConstantReactanceCommand");

    if (xDirectSync == null)
      throw new ProcessingException("XDirectSync already has nothing assigned.");

    apply(
        new UnAssignXDirectSyncFromSynchronousMachineTimeConstantReactanceEvent(
            command.getSynchronousMachineTimeConstantReactanceId()));
  }

  @CommandHandler
  public void handle(AssignXDirectTransToSynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    LOGGER.info(
        "Handling command AssignXDirectTransToSynchronousMachineTimeConstantReactanceCommand");

    if (xDirectTrans != null && xDirectTrans.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "XDirectTrans already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignXDirectTransToSynchronousMachineTimeConstantReactanceEvent(
            command.getSynchronousMachineTimeConstantReactanceId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignXDirectTransFromSynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    LOGGER.info(
        "Handlign command UnAssignXDirectTransFromSynchronousMachineTimeConstantReactanceCommand");

    if (xDirectTrans == null)
      throw new ProcessingException("XDirectTrans already has nothing assigned.");

    apply(
        new UnAssignXDirectTransFromSynchronousMachineTimeConstantReactanceEvent(
            command.getSynchronousMachineTimeConstantReactanceId()));
  }

  @CommandHandler
  public void handle(AssignXQuadSubtransToSynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    LOGGER.info(
        "Handling command AssignXQuadSubtransToSynchronousMachineTimeConstantReactanceCommand");

    if (xQuadSubtrans != null && xQuadSubtrans.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "XQuadSubtrans already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignXQuadSubtransToSynchronousMachineTimeConstantReactanceEvent(
            command.getSynchronousMachineTimeConstantReactanceId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(
      UnAssignXQuadSubtransFromSynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    LOGGER.info(
        "Handlign command UnAssignXQuadSubtransFromSynchronousMachineTimeConstantReactanceCommand");

    if (xQuadSubtrans == null)
      throw new ProcessingException("XQuadSubtrans already has nothing assigned.");

    apply(
        new UnAssignXQuadSubtransFromSynchronousMachineTimeConstantReactanceEvent(
            command.getSynchronousMachineTimeConstantReactanceId()));
  }

  @CommandHandler
  public void handle(AssignXQuadSyncToSynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignXQuadSyncToSynchronousMachineTimeConstantReactanceCommand");

    if (xQuadSync != null && xQuadSync.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "XQuadSync already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignXQuadSyncToSynchronousMachineTimeConstantReactanceEvent(
            command.getSynchronousMachineTimeConstantReactanceId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignXQuadSyncFromSynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    LOGGER.info(
        "Handlign command UnAssignXQuadSyncFromSynchronousMachineTimeConstantReactanceCommand");

    if (xQuadSync == null) throw new ProcessingException("XQuadSync already has nothing assigned.");

    apply(
        new UnAssignXQuadSyncFromSynchronousMachineTimeConstantReactanceEvent(
            command.getSynchronousMachineTimeConstantReactanceId()));
  }

  @CommandHandler
  public void handle(AssignXQuadTransToSynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    LOGGER.info(
        "Handling command AssignXQuadTransToSynchronousMachineTimeConstantReactanceCommand");

    if (xQuadTrans != null && xQuadTrans.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "XQuadTrans already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignXQuadTransToSynchronousMachineTimeConstantReactanceEvent(
            command.getSynchronousMachineTimeConstantReactanceId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignXQuadTransFromSynchronousMachineTimeConstantReactanceCommand command)
      throws Exception {
    LOGGER.info(
        "Handlign command UnAssignXQuadTransFromSynchronousMachineTimeConstantReactanceCommand");

    if (xQuadTrans == null)
      throw new ProcessingException("XQuadTrans already has nothing assigned.");

    apply(
        new UnAssignXQuadTransFromSynchronousMachineTimeConstantReactanceEvent(
            command.getSynchronousMachineTimeConstantReactanceId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateSynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info("Event sourcing CreateSynchronousMachineTimeConstantReactanceEvent");
    this.synchronousMachineTimeConstantReactanceId =
        event.getSynchronousMachineTimeConstantReactanceId();
    this.modelType = event.getModelType();
    this.rotorType = event.getRotorType();
  }

  @EventSourcingHandler
  void on(UpdateSynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.ks = event.getKs();
    this.modelType = event.getModelType();
    this.rotorType = event.getRotorType();
    this.tc = event.getTc();
    this.tpdo = event.getTpdo();
    this.tppdo = event.getTppdo();
    this.tppqo = event.getTppqo();
    this.tpqo = event.getTpqo();
    this.xDirectSubtrans = event.getXDirectSubtrans();
    this.xDirectSync = event.getXDirectSync();
    this.xDirectTrans = event.getXDirectTrans();
    this.xQuadSubtrans = event.getXQuadSubtrans();
    this.xQuadSync = event.getXQuadSync();
    this.xQuadTrans = event.getXQuadTrans();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignKsToSynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info("Event sourcing AssignKsToSynchronousMachineTimeConstantReactanceEvent");
    this.ks = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignKsFromSynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info("Event sourcing UnAssignKsFromSynchronousMachineTimeConstantReactanceEvent");
    this.ks = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTcToSynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info("Event sourcing AssignTcToSynchronousMachineTimeConstantReactanceEvent");
    this.tc = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTcFromSynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info("Event sourcing UnAssignTcFromSynchronousMachineTimeConstantReactanceEvent");
    this.tc = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTpdoToSynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info("Event sourcing AssignTpdoToSynchronousMachineTimeConstantReactanceEvent");
    this.tpdo = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTpdoFromSynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info("Event sourcing UnAssignTpdoFromSynchronousMachineTimeConstantReactanceEvent");
    this.tpdo = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTppdoToSynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info("Event sourcing AssignTppdoToSynchronousMachineTimeConstantReactanceEvent");
    this.tppdo = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTppdoFromSynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info("Event sourcing UnAssignTppdoFromSynchronousMachineTimeConstantReactanceEvent");
    this.tppdo = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTppqoToSynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info("Event sourcing AssignTppqoToSynchronousMachineTimeConstantReactanceEvent");
    this.tppqo = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTppqoFromSynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info("Event sourcing UnAssignTppqoFromSynchronousMachineTimeConstantReactanceEvent");
    this.tppqo = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTpqoToSynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info("Event sourcing AssignTpqoToSynchronousMachineTimeConstantReactanceEvent");
    this.tpqo = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTpqoFromSynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info("Event sourcing UnAssignTpqoFromSynchronousMachineTimeConstantReactanceEvent");
    this.tpqo = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignXDirectSubtransToSynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info(
        "Event sourcing AssignXDirectSubtransToSynchronousMachineTimeConstantReactanceEvent");
    this.xDirectSubtrans = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignXDirectSubtransFromSynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info(
        "Event sourcing UnAssignXDirectSubtransFromSynchronousMachineTimeConstantReactanceEvent");
    this.xDirectSubtrans = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignXDirectSyncToSynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info("Event sourcing AssignXDirectSyncToSynchronousMachineTimeConstantReactanceEvent");
    this.xDirectSync = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignXDirectSyncFromSynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info(
        "Event sourcing UnAssignXDirectSyncFromSynchronousMachineTimeConstantReactanceEvent");
    this.xDirectSync = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignXDirectTransToSynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info("Event sourcing AssignXDirectTransToSynchronousMachineTimeConstantReactanceEvent");
    this.xDirectTrans = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignXDirectTransFromSynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info(
        "Event sourcing UnAssignXDirectTransFromSynchronousMachineTimeConstantReactanceEvent");
    this.xDirectTrans = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignXQuadSubtransToSynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info("Event sourcing AssignXQuadSubtransToSynchronousMachineTimeConstantReactanceEvent");
    this.xQuadSubtrans = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignXQuadSubtransFromSynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info(
        "Event sourcing UnAssignXQuadSubtransFromSynchronousMachineTimeConstantReactanceEvent");
    this.xQuadSubtrans = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignXQuadSyncToSynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info("Event sourcing AssignXQuadSyncToSynchronousMachineTimeConstantReactanceEvent");
    this.xQuadSync = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignXQuadSyncFromSynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info("Event sourcing UnAssignXQuadSyncFromSynchronousMachineTimeConstantReactanceEvent");
    this.xQuadSync = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignXQuadTransToSynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info("Event sourcing AssignXQuadTransToSynchronousMachineTimeConstantReactanceEvent");
    this.xQuadTrans = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignXQuadTransFromSynchronousMachineTimeConstantReactanceEvent event) {
    LOGGER.info(
        "Event sourcing UnAssignXQuadTransFromSynchronousMachineTimeConstantReactanceEvent");
    this.xQuadTrans = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID synchronousMachineTimeConstantReactanceId;

  private SynchronousMachineModelKind modelType;
  private RotorKind rotorType;
  private Simple_Float ks = null;
  private Seconds tc = null;
  private Seconds tpdo = null;
  private Seconds tppdo = null;
  private Seconds tppqo = null;
  private Seconds tpqo = null;
  private PU xDirectSubtrans = null;
  private PU xDirectSync = null;
  private PU xDirectTrans = null;
  private PU xQuadSubtrans = null;
  private PU xQuadSync = null;
  private PU xQuadTrans = null;

  private static final Logger LOGGER =
      Logger.getLogger(SynchronousMachineTimeConstantReactanceAggregate.class.getName());
}
