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
 * Aggregate handler for CurrentFlow as outlined for the CQRS pattern, all write responsibilities
 * related to CurrentFlow are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class CurrentFlowAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public CurrentFlowAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public CurrentFlowAggregate(CreateCurrentFlowCommand command) throws Exception {
    LOGGER.info("Handling command CreateCurrentFlowCommand");
    CreateCurrentFlowEvent event =
        new CreateCurrentFlowEvent(
            command.getCurrentFlowId(), command.getMultiplier(), command.getUnit());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateCurrentFlowCommand command) throws Exception {
    LOGGER.info("handling command UpdateCurrentFlowCommand");
    UpdateCurrentFlowEvent event =
        new UpdateCurrentFlowEvent(
            command.getCurrentFlowId(),
            command.getMultiplier(),
            command.getUnit(),
            command.getValue());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteCurrentFlowCommand command) throws Exception {
    LOGGER.info("Handling command DeleteCurrentFlowCommand");
    apply(new DeleteCurrentFlowEvent(command.getCurrentFlowId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignValueToCurrentFlowCommand command) throws Exception {
    LOGGER.info("Handling command AssignValueToCurrentFlowCommand");

    if (value != null && value.getFloatProxyId() == command.getAssignment().getFloatProxyId())
      throw new ProcessingException(
          "Value already assigned with id " + command.getAssignment().getFloatProxyId());

    apply(new AssignValueToCurrentFlowEvent(command.getCurrentFlowId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignValueFromCurrentFlowCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignValueFromCurrentFlowCommand");

    if (value == null) throw new ProcessingException("Value already has nothing assigned.");

    apply(new UnAssignValueFromCurrentFlowEvent(command.getCurrentFlowId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateCurrentFlowEvent event) {
    LOGGER.info("Event sourcing CreateCurrentFlowEvent");
    this.currentFlowId = event.getCurrentFlowId();
    this.multiplier = event.getMultiplier();
    this.unit = event.getUnit();
  }

  @EventSourcingHandler
  void on(UpdateCurrentFlowEvent event) {
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
  void on(AssignValueToCurrentFlowEvent event) {
    LOGGER.info("Event sourcing AssignValueToCurrentFlowEvent");
    this.value = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignValueFromCurrentFlowEvent event) {
    LOGGER.info("Event sourcing UnAssignValueFromCurrentFlowEvent");
    this.value = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID currentFlowId;

  private UnitMultiplier multiplier;
  private UnitSymbol unit;
  private FloatProxy value = null;
  private CsConverter maxIdc = null;
  private CsConverter minIdc = null;
  private CsConverter ratedIdc = null;
  private VsConverter maxValveCurrent = null;
  private BusbarSection ipMax = null;
  private ExternalNetworkInjection maxInitialSymShCCurrent = null;
  private ExternalNetworkInjection minInitialSymShCCurrent = null;
  private PetersenCoil offsetCurrent = null;
  private PetersenCoil positionCurrent = null;
  private PowerTransformer beforeShCircuitHighestOperatingCurrent = null;
  private SeriesCompensator varistorRatedCurrent = null;
  private SwitchProxy ratedCurrent = null;
  private SynchronousMachine ikk = null;
  private SynchronousMachineDetailed ifdBaseValue = null;

  private static final Logger LOGGER = Logger.getLogger(CurrentFlowAggregate.class.getName());
}
