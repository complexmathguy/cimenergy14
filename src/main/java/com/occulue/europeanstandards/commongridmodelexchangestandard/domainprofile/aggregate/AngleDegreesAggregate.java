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
 * Aggregate handler for AngleDegrees as outlined for the CQRS pattern, all write responsibilities
 * related to AngleDegrees are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class AngleDegreesAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public AngleDegreesAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public AngleDegreesAggregate(CreateAngleDegreesCommand command) throws Exception {
    LOGGER.info("Handling command CreateAngleDegreesCommand");
    CreateAngleDegreesEvent event =
        new CreateAngleDegreesEvent(
            command.getAngleDegreesId(), command.getMultiplier(), command.getUnit());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateAngleDegreesCommand command) throws Exception {
    LOGGER.info("handling command UpdateAngleDegreesCommand");
    UpdateAngleDegreesEvent event =
        new UpdateAngleDegreesEvent(
            command.getAngleDegreesId(),
            command.getMultiplier(),
            command.getUnit(),
            command.getValue());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteAngleDegreesCommand command) throws Exception {
    LOGGER.info("Handling command DeleteAngleDegreesCommand");
    apply(new DeleteAngleDegreesEvent(command.getAngleDegreesId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignValueToAngleDegreesCommand command) throws Exception {
    LOGGER.info("Handling command AssignValueToAngleDegreesCommand");

    if (value != null && value.getFloatProxyId() == command.getAssignment().getFloatProxyId())
      throw new ProcessingException(
          "Value already assigned with id " + command.getAssignment().getFloatProxyId());

    apply(new AssignValueToAngleDegreesEvent(command.getAngleDegreesId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignValueFromAngleDegreesCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignValueFromAngleDegreesCommand");

    if (value == null) throw new ProcessingException("Value already has nothing assigned.");

    apply(new UnAssignValueFromAngleDegreesEvent(command.getAngleDegreesId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateAngleDegreesEvent event) {
    LOGGER.info("Event sourcing CreateAngleDegreesEvent");
    this.angleDegreesId = event.getAngleDegreesId();
    this.multiplier = event.getMultiplier();
    this.unit = event.getUnit();
  }

  @EventSourcingHandler
  void on(UpdateAngleDegreesEvent event) {
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
  void on(AssignValueToAngleDegreesEvent event) {
    LOGGER.info("Event sourcing AssignValueToAngleDegreesEvent");
    this.value = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignValueFromAngleDegreesEvent event) {
    LOGGER.info("Event sourcing UnAssignValueFromAngleDegreesEvent");
    this.value = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID angleDegreesId;

  private UnitMultiplier multiplier;
  private UnitSymbol unit;
  private FloatProxy value = null;
  private CsConverter maxAlpha = null;
  private CsConverter maxGamma = null;
  private CsConverter minAlpha = null;
  private CsConverter minGamma = null;
  private PhaseTapChangerAsymmetrical windingConnectionAngle = null;
  private PhaseTapChangerLinear stepPhaseShiftIncrement = null;
  private PhaseTapChangerTablePoint angle = null;
  private PowerTransformer beforeShortCircuitAnglePf = null;
  private ExcIEEEST3A thetap = null;
  private WindAeroLinearIEC thetazero = null;
  private WindContPitchAngleIEC thetamax = null;
  private WindContPitchAngleIEC thetamin = null;
  private DiagramObject rotation = null;

  private static final Logger LOGGER = Logger.getLogger(AngleDegreesAggregate.class.getName());
}
