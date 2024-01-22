package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.aggregate;

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
 * Aggregate handler for Quality61850 as outlined for the CQRS pattern, all write responsibilities
 * related to Quality61850 are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class Quality61850Aggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public Quality61850Aggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public Quality61850Aggregate(CreateQuality61850Command command) throws Exception {
    LOGGER.info("Handling command CreateQuality61850Command");
    CreateQuality61850Event event =
        new CreateQuality61850Event(
            command.getQuality61850Id(), command.getSource(), command.getValidity());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateQuality61850Command command) throws Exception {
    LOGGER.info("handling command UpdateQuality61850Command");
    UpdateQuality61850Event event =
        new UpdateQuality61850Event(
            command.getQuality61850Id(),
            command.getBadReference(),
            command.getEstimatorReplaced(),
            command.getFailure(),
            command.getOldData(),
            command.getOperatorBlocked(),
            command.getOscillatory(),
            command.getOutOfRange(),
            command.getOverFlow(),
            command.getSource(),
            command.getSuspect(),
            command.getTest(),
            command.getValidity());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteQuality61850Command command) throws Exception {
    LOGGER.info("Handling command DeleteQuality61850Command");
    apply(new DeleteQuality61850Event(command.getQuality61850Id()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignBadReferenceToQuality61850Command command) throws Exception {
    LOGGER.info("Handling command AssignBadReferenceToQuality61850Command");

    if (badReference != null
        && badReference.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "BadReference already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(
        new AssignBadReferenceToQuality61850Event(
            command.getQuality61850Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignBadReferenceFromQuality61850Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignBadReferenceFromQuality61850Command");

    if (badReference == null)
      throw new ProcessingException("BadReference already has nothing assigned.");

    apply(new UnAssignBadReferenceFromQuality61850Event(command.getQuality61850Id()));
  }

  @CommandHandler
  public void handle(AssignEstimatorReplacedToQuality61850Command command) throws Exception {
    LOGGER.info("Handling command AssignEstimatorReplacedToQuality61850Command");

    if (estimatorReplaced != null
        && estimatorReplaced.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "EstimatorReplaced already assigned with id "
              + command.getAssignment().getBooleanProxyId());

    apply(
        new AssignEstimatorReplacedToQuality61850Event(
            command.getQuality61850Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignEstimatorReplacedFromQuality61850Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignEstimatorReplacedFromQuality61850Command");

    if (estimatorReplaced == null)
      throw new ProcessingException("EstimatorReplaced already has nothing assigned.");

    apply(new UnAssignEstimatorReplacedFromQuality61850Event(command.getQuality61850Id()));
  }

  @CommandHandler
  public void handle(AssignFailureToQuality61850Command command) throws Exception {
    LOGGER.info("Handling command AssignFailureToQuality61850Command");

    if (failure != null
        && failure.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Failure already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(
        new AssignFailureToQuality61850Event(command.getQuality61850Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignFailureFromQuality61850Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignFailureFromQuality61850Command");

    if (failure == null) throw new ProcessingException("Failure already has nothing assigned.");

    apply(new UnAssignFailureFromQuality61850Event(command.getQuality61850Id()));
  }

  @CommandHandler
  public void handle(AssignOldDataToQuality61850Command command) throws Exception {
    LOGGER.info("Handling command AssignOldDataToQuality61850Command");

    if (oldData != null
        && oldData.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "OldData already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(
        new AssignOldDataToQuality61850Event(command.getQuality61850Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignOldDataFromQuality61850Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignOldDataFromQuality61850Command");

    if (oldData == null) throw new ProcessingException("OldData already has nothing assigned.");

    apply(new UnAssignOldDataFromQuality61850Event(command.getQuality61850Id()));
  }

  @CommandHandler
  public void handle(AssignOperatorBlockedToQuality61850Command command) throws Exception {
    LOGGER.info("Handling command AssignOperatorBlockedToQuality61850Command");

    if (operatorBlocked != null
        && operatorBlocked.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "OperatorBlocked already assigned with id "
              + command.getAssignment().getBooleanProxyId());

    apply(
        new AssignOperatorBlockedToQuality61850Event(
            command.getQuality61850Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignOperatorBlockedFromQuality61850Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignOperatorBlockedFromQuality61850Command");

    if (operatorBlocked == null)
      throw new ProcessingException("OperatorBlocked already has nothing assigned.");

    apply(new UnAssignOperatorBlockedFromQuality61850Event(command.getQuality61850Id()));
  }

  @CommandHandler
  public void handle(AssignOscillatoryToQuality61850Command command) throws Exception {
    LOGGER.info("Handling command AssignOscillatoryToQuality61850Command");

    if (oscillatory != null
        && oscillatory.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Oscillatory already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(
        new AssignOscillatoryToQuality61850Event(
            command.getQuality61850Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignOscillatoryFromQuality61850Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignOscillatoryFromQuality61850Command");

    if (oscillatory == null)
      throw new ProcessingException("Oscillatory already has nothing assigned.");

    apply(new UnAssignOscillatoryFromQuality61850Event(command.getQuality61850Id()));
  }

  @CommandHandler
  public void handle(AssignOutOfRangeToQuality61850Command command) throws Exception {
    LOGGER.info("Handling command AssignOutOfRangeToQuality61850Command");

    if (outOfRange != null
        && outOfRange.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "OutOfRange already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(
        new AssignOutOfRangeToQuality61850Event(
            command.getQuality61850Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignOutOfRangeFromQuality61850Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignOutOfRangeFromQuality61850Command");

    if (outOfRange == null)
      throw new ProcessingException("OutOfRange already has nothing assigned.");

    apply(new UnAssignOutOfRangeFromQuality61850Event(command.getQuality61850Id()));
  }

  @CommandHandler
  public void handle(AssignOverFlowToQuality61850Command command) throws Exception {
    LOGGER.info("Handling command AssignOverFlowToQuality61850Command");

    if (overFlow != null
        && overFlow.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "OverFlow already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(
        new AssignOverFlowToQuality61850Event(
            command.getQuality61850Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignOverFlowFromQuality61850Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignOverFlowFromQuality61850Command");

    if (overFlow == null) throw new ProcessingException("OverFlow already has nothing assigned.");

    apply(new UnAssignOverFlowFromQuality61850Event(command.getQuality61850Id()));
  }

  @CommandHandler
  public void handle(AssignSuspectToQuality61850Command command) throws Exception {
    LOGGER.info("Handling command AssignSuspectToQuality61850Command");

    if (suspect != null
        && suspect.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Suspect already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(
        new AssignSuspectToQuality61850Event(command.getQuality61850Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSuspectFromQuality61850Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignSuspectFromQuality61850Command");

    if (suspect == null) throw new ProcessingException("Suspect already has nothing assigned.");

    apply(new UnAssignSuspectFromQuality61850Event(command.getQuality61850Id()));
  }

  @CommandHandler
  public void handle(AssignTestToQuality61850Command command) throws Exception {
    LOGGER.info("Handling command AssignTestToQuality61850Command");

    if (test != null && test.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Test already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(new AssignTestToQuality61850Event(command.getQuality61850Id(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignTestFromQuality61850Command command) throws Exception {
    LOGGER.info("Handlign command UnAssignTestFromQuality61850Command");

    if (test == null) throw new ProcessingException("Test already has nothing assigned.");

    apply(new UnAssignTestFromQuality61850Event(command.getQuality61850Id()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateQuality61850Event event) {
    LOGGER.info("Event sourcing CreateQuality61850Event");
    this.quality61850Id = event.getQuality61850Id();
    this.source = event.getSource();
    this.validity = event.getValidity();
  }

  @EventSourcingHandler
  void on(UpdateQuality61850Event event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.badReference = event.getBadReference();
    this.estimatorReplaced = event.getEstimatorReplaced();
    this.failure = event.getFailure();
    this.oldData = event.getOldData();
    this.operatorBlocked = event.getOperatorBlocked();
    this.oscillatory = event.getOscillatory();
    this.outOfRange = event.getOutOfRange();
    this.overFlow = event.getOverFlow();
    this.source = event.getSource();
    this.suspect = event.getSuspect();
    this.test = event.getTest();
    this.validity = event.getValidity();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignBadReferenceToQuality61850Event event) {
    LOGGER.info("Event sourcing AssignBadReferenceToQuality61850Event");
    this.badReference = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignBadReferenceFromQuality61850Event event) {
    LOGGER.info("Event sourcing UnAssignBadReferenceFromQuality61850Event");
    this.badReference = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignEstimatorReplacedToQuality61850Event event) {
    LOGGER.info("Event sourcing AssignEstimatorReplacedToQuality61850Event");
    this.estimatorReplaced = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignEstimatorReplacedFromQuality61850Event event) {
    LOGGER.info("Event sourcing UnAssignEstimatorReplacedFromQuality61850Event");
    this.estimatorReplaced = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignFailureToQuality61850Event event) {
    LOGGER.info("Event sourcing AssignFailureToQuality61850Event");
    this.failure = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignFailureFromQuality61850Event event) {
    LOGGER.info("Event sourcing UnAssignFailureFromQuality61850Event");
    this.failure = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignOldDataToQuality61850Event event) {
    LOGGER.info("Event sourcing AssignOldDataToQuality61850Event");
    this.oldData = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignOldDataFromQuality61850Event event) {
    LOGGER.info("Event sourcing UnAssignOldDataFromQuality61850Event");
    this.oldData = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignOperatorBlockedToQuality61850Event event) {
    LOGGER.info("Event sourcing AssignOperatorBlockedToQuality61850Event");
    this.operatorBlocked = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignOperatorBlockedFromQuality61850Event event) {
    LOGGER.info("Event sourcing UnAssignOperatorBlockedFromQuality61850Event");
    this.operatorBlocked = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignOscillatoryToQuality61850Event event) {
    LOGGER.info("Event sourcing AssignOscillatoryToQuality61850Event");
    this.oscillatory = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignOscillatoryFromQuality61850Event event) {
    LOGGER.info("Event sourcing UnAssignOscillatoryFromQuality61850Event");
    this.oscillatory = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignOutOfRangeToQuality61850Event event) {
    LOGGER.info("Event sourcing AssignOutOfRangeToQuality61850Event");
    this.outOfRange = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignOutOfRangeFromQuality61850Event event) {
    LOGGER.info("Event sourcing UnAssignOutOfRangeFromQuality61850Event");
    this.outOfRange = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignOverFlowToQuality61850Event event) {
    LOGGER.info("Event sourcing AssignOverFlowToQuality61850Event");
    this.overFlow = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignOverFlowFromQuality61850Event event) {
    LOGGER.info("Event sourcing UnAssignOverFlowFromQuality61850Event");
    this.overFlow = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSuspectToQuality61850Event event) {
    LOGGER.info("Event sourcing AssignSuspectToQuality61850Event");
    this.suspect = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSuspectFromQuality61850Event event) {
    LOGGER.info("Event sourcing UnAssignSuspectFromQuality61850Event");
    this.suspect = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignTestToQuality61850Event event) {
    LOGGER.info("Event sourcing AssignTestToQuality61850Event");
    this.test = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignTestFromQuality61850Event event) {
    LOGGER.info("Event sourcing UnAssignTestFromQuality61850Event");
    this.test = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID quality61850Id;

  private Source source;
  private Validity validity;
  private BooleanProxy badReference = null;
  private BooleanProxy estimatorReplaced = null;
  private BooleanProxy failure = null;
  private BooleanProxy oldData = null;
  private BooleanProxy operatorBlocked = null;
  private BooleanProxy oscillatory = null;
  private BooleanProxy outOfRange = null;
  private BooleanProxy overFlow = null;
  private BooleanProxy suspect = null;
  private BooleanProxy test = null;

  private static final Logger LOGGER = Logger.getLogger(Quality61850Aggregate.class.getName());
}
