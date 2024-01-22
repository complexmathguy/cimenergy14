package com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.aggregate;

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
 * Aggregate handler for Resistance as outlined for the CQRS pattern, all write responsibilities
 * related to Resistance are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ResistanceAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ResistanceAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ResistanceAggregate(CreateResistanceCommand command) throws Exception {
    LOGGER.info("Handling command CreateResistanceCommand");
    CreateResistanceEvent event =
        new CreateResistanceEvent(
            command.getResistanceId(), command.getMultiplier(), command.getUnit());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateResistanceCommand command) throws Exception {
    LOGGER.info("handling command UpdateResistanceCommand");
    UpdateResistanceEvent event =
        new UpdateResistanceEvent(
            command.getResistanceId(),
            command.getMultiplier(),
            command.getUnit(),
            command.getValue());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteResistanceCommand command) throws Exception {
    LOGGER.info("Handling command DeleteResistanceCommand");
    apply(new DeleteResistanceEvent(command.getResistanceId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignValueToResistanceCommand command) throws Exception {
    LOGGER.info("Handling command AssignValueToResistanceCommand");

    if (value != null && value.getFloatProxyId() == command.getAssignment().getFloatProxyId())
      throw new ProcessingException(
          "Value already assigned with id " + command.getAssignment().getFloatProxyId());

    apply(new AssignValueToResistanceEvent(command.getResistanceId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignValueFromResistanceCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignValueFromResistanceCommand");

    if (value == null) throw new ProcessingException("Value already has nothing assigned.");

    apply(new UnAssignValueFromResistanceEvent(command.getResistanceId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateResistanceEvent event) {
    LOGGER.info("Event sourcing CreateResistanceEvent");
    this.resistanceId = event.getResistanceId();
    this.multiplier = event.getMultiplier();
    this.unit = event.getUnit();
  }

  @EventSourcingHandler
  void on(UpdateResistanceEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.multiplier = event.getMultiplier();
    this.unit = event.getUnit();
    this.value = event.getValue();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignValueToResistanceEvent event) {
    LOGGER.info("Event sourcing AssignValueToResistanceEvent");
    this.value = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignValueFromResistanceEvent event) {
    LOGGER.info("Event sourcing UnAssignValueFromResistanceEvent");
    this.value = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID resistanceId;

  private UnitMultiplier multiplier;
  private UnitSymbol unit;
  private FloatProxy value = null;
  private ACDCConverter resistiveLoss = null;
  private DCGround r = null;
  private DCLineSegment resistance = null;
  private ACLineSegment r0 = null;
  private SynchronousMachine earthingStarPointR = null;
  private TransformerEnd rground = null;
  private EquivalentBranch negativeR12 = null;
  private EquivalentBranch negativeR21 = null;
  private EquivalentBranch positiveR12 = null;
  private EquivalentBranch positiveR21 = null;
  private EquivalentBranch r21 = null;
  private EquivalentBranch zeroR12 = null;
  private EquivalentBranch zeroR21 = null;
  private EquivalentInjection r2 = null;

  private static final Logger LOGGER = Logger.getLogger(ResistanceAggregate.class.getName());
}
