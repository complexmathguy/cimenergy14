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
 * Aggregate handler for ActivePower as outlined for the CQRS pattern, all write responsibilities
 * related to ActivePower are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class ActivePowerAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public ActivePowerAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public ActivePowerAggregate(CreateActivePowerCommand command) throws Exception {
    LOGGER.info("Handling command CreateActivePowerCommand");
    CreateActivePowerEvent event =
        new CreateActivePowerEvent(
            command.getActivePowerId(), command.getMultiplier(), command.getUnit());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateActivePowerCommand command) throws Exception {
    LOGGER.info("handling command UpdateActivePowerCommand");
    UpdateActivePowerEvent event =
        new UpdateActivePowerEvent(
            command.getActivePowerId(),
            command.getMultiplier(),
            command.getUnit(),
            command.getValue());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteActivePowerCommand command) throws Exception {
    LOGGER.info("Handling command DeleteActivePowerCommand");
    apply(new DeleteActivePowerEvent(command.getActivePowerId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignValueToActivePowerCommand command) throws Exception {
    LOGGER.info("Handling command AssignValueToActivePowerCommand");

    if (value != null && value.getFloatProxyId() == command.getAssignment().getFloatProxyId())
      throw new ProcessingException(
          "Value already assigned with id " + command.getAssignment().getFloatProxyId());

    apply(new AssignValueToActivePowerEvent(command.getActivePowerId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignValueFromActivePowerCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignValueFromActivePowerCommand");

    if (value == null) throw new ProcessingException("Value already has nothing assigned.");

    apply(new UnAssignValueFromActivePowerEvent(command.getActivePowerId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateActivePowerEvent event) {
    LOGGER.info("Event sourcing CreateActivePowerEvent");
    this.activePowerId = event.getActivePowerId();
    this.multiplier = event.getMultiplier();
    this.unit = event.getUnit();
  }

  @EventSourcingHandler
  void on(UpdateActivePowerEvent event) {
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
  void on(AssignValueToActivePowerEvent event) {
    LOGGER.info("Event sourcing AssignValueToActivePowerEvent");
    this.value = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignValueFromActivePowerEvent event) {
    LOGGER.info("Event sourcing UnAssignValueFromActivePowerEvent");
    this.value = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID activePowerId;

  private UnitMultiplier multiplier;
  private UnitSymbol unit;
  private FloatProxy value = null;
  private ACDCConverter idleLoss = null;
  private GeneratingUnit initialP = null;
  private GeneratingUnit maximumAllowableSpinningReserve = null;
  private GeneratingUnit maxOperatingP = null;
  private GeneratingUnit minOperatingP = null;
  private GeneratingUnit nominalP = null;
  private GeneratingUnit ratedGrossMaxP = null;
  private GeneratingUnit ratedGrossMinP = null;
  private GeneratingUnit ratedNetMaxP = null;
  private AsynchronousMachine ratedMechanicalPower = null;
  private EnergyConsumer pfixed = null;
  private ExternalNetworkInjection maxP = null;
  private ExternalNetworkInjection minP = null;
  private SvInjection pInjection = null;
  private SvPowerFlow p = null;
  private GovHydroIEEE0 mwbase = null;
  private GovGAST1 db2 = null;
  private GovGAST2 trate = null;
  private TurbLCFB1 pmwset = null;

  private static final Logger LOGGER = Logger.getLogger(ActivePowerAggregate.class.getName());
}
