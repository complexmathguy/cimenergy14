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
 * Aggregate handler for Reactance as outlined for the CQRS pattern, all write responsibilities
 * related to Reactance are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ReactanceAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ReactanceAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ReactanceAggregate(CreateReactanceCommand command) throws Exception {
    LOGGER.info("Handling command CreateReactanceCommand");
    CreateReactanceEvent event =
        new CreateReactanceEvent(
            command.getReactanceId(), command.getMultiplier(), command.getUnit());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateReactanceCommand command) throws Exception {
    LOGGER.info("handling command UpdateReactanceCommand");
    UpdateReactanceEvent event =
        new UpdateReactanceEvent(
            command.getReactanceId(),
            command.getMultiplier(),
            command.getUnit(),
            command.getValue());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteReactanceCommand command) throws Exception {
    LOGGER.info("Handling command DeleteReactanceCommand");
    apply(new DeleteReactanceEvent(command.getReactanceId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignValueToReactanceCommand command) throws Exception {
    LOGGER.info("Handling command AssignValueToReactanceCommand");

    if (value != null && value.getFloatProxyId() == command.getAssignment().getFloatProxyId())
      throw new ProcessingException(
          "Value already assigned with id " + command.getAssignment().getFloatProxyId());

    apply(new AssignValueToReactanceEvent(command.getReactanceId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignValueFromReactanceCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignValueFromReactanceCommand");

    if (value == null) throw new ProcessingException("Value already has nothing assigned.");

    apply(new UnAssignValueFromReactanceEvent(command.getReactanceId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateReactanceEvent event) {
    LOGGER.info("Event sourcing CreateReactanceEvent");
    this.reactanceId = event.getReactanceId();
    this.multiplier = event.getMultiplier();
    this.unit = event.getUnit();
  }

  @EventSourcingHandler
  void on(UpdateReactanceEvent event) {
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
  void on(AssignValueToReactanceEvent event) {
    LOGGER.info("Event sourcing AssignValueToReactanceEvent");
    this.value = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignValueFromReactanceEvent event) {
    LOGGER.info("Event sourcing UnAssignValueFromReactanceEvent");
    this.value = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID reactanceId;

  private UnitMultiplier multiplier;
  private UnitSymbol unit;
  private FloatProxy value = null;
  private ACLineSegment x = null;
  private ACLineSegment x0 = null;
  private PetersenCoil xGroundMax = null;
  private PetersenCoil xGroundMin = null;
  private PetersenCoil xGroundNominal = null;
  private PhaseTapChangerLinear xMax = null;
  private PhaseTapChangerLinear xMin = null;
  private StaticVarCompensator capacitiveRating = null;
  private StaticVarCompensator inductiveRating = null;
  private SynchronousMachine earthingStarPointX = null;
  private TransformerEnd xground = null;
  private EquivalentBranch negativeX12 = null;
  private EquivalentBranch negativeX21 = null;
  private EquivalentBranch positiveX12 = null;
  private EquivalentBranch positiveX21 = null;
  private EquivalentBranch x21 = null;
  private EquivalentBranch zeroX12 = null;
  private EquivalentBranch zeroX21 = null;
  private EquivalentInjection x2 = null;

  private static final Logger LOGGER = Logger.getLogger(ReactanceAggregate.class.getName());
}
