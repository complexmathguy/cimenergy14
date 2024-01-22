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
 * Aggregate handler for IntegerProxy as outlined for the CQRS pattern, all write responsibilities
 * related to IntegerProxy are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class IntegerProxyAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public IntegerProxyAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public IntegerProxyAggregate(CreateIntegerProxyCommand command) throws Exception {
    LOGGER.info("Handling command CreateIntegerProxyCommand");
    CreateIntegerProxyEvent event = new CreateIntegerProxyEvent(command.getIntegerProxyId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateIntegerProxyCommand command) throws Exception {
    LOGGER.info("handling command UpdateIntegerProxyCommand");
    UpdateIntegerProxyEvent event = new UpdateIntegerProxyEvent(command.getIntegerProxyId());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteIntegerProxyCommand command) throws Exception {
    LOGGER.info("Handling command DeleteIntegerProxyCommand");
    apply(new DeleteIntegerProxyEvent(command.getIntegerProxyId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateIntegerProxyEvent event) {
    LOGGER.info("Event sourcing CreateIntegerProxyEvent");
    this.integerProxyId = event.getIntegerProxyId();
  }

  @EventSourcingHandler
  void on(UpdateIntegerProxyEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID integerProxyId;

  private ACDCConverter numberOfValves = null;
  private BusNameMarker priority = null;
  private AccumulatorLimit value = null;
  private Command normalValue = null;
  private ACDCTerminal sequenceNumber = null;
  private AsynchronousMachine polePairNumber = null;
  private NonlinearShuntCompensatorPoint sectionNumber = null;
  private PowerTransformerEnd phaseAngleClock = null;
  private ShuntCompensator maximumSections = null;
  private ShuntCompensator normalSections = null;
  private ShuntCompensator switchOnCount = null;
  private TapChanger highStep = null;
  private TapChanger lowStep = null;
  private TapChanger neutralStep = null;
  private TapChanger normalStep = null;
  private TapChangerTablePoint step = null;
  private TransformerEnd endNumber = null;
  private ExcANS blint = null;
  private ExcANS krvecc = null;
  private ExcANS kvfif = null;
  private PssIEEE2B m = null;
  private PssIEEE2B n = null;
  private WindDynamicsLookupTable sequence = null;
  private ProprietaryParameterDynamics integerParameterValue = null;
  private ProprietaryParameterDynamics parameterNumber = null;
  private DiagramObject drawingOrder = null;

  private static final Logger LOGGER = Logger.getLogger(IntegerProxyAggregate.class.getName());
}
