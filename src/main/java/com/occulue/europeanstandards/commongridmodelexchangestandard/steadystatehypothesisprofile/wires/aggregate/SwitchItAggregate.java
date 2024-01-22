package com.occulue.europeanstandards.commongridmodelexchangestandard.steadystatehypothesisprofile.wires.aggregate;

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
 * Aggregate handler for SwitchIt as outlined for the CQRS pattern, all write responsibilities
 * related to SwitchIt are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class SwitchItAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public SwitchItAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public SwitchItAggregate(CreateSwitchItCommand command) throws Exception {
    LOGGER.info("Handling command CreateSwitchItCommand");
    CreateSwitchItEvent event = new CreateSwitchItEvent(command.getSwitchItId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateSwitchItCommand command) throws Exception {
    LOGGER.info("handling command UpdateSwitchItCommand");
    UpdateSwitchItEvent event = new UpdateSwitchItEvent(command.getSwitchItId(), command.getOpen());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteSwitchItCommand command) throws Exception {
    LOGGER.info("Handling command DeleteSwitchItCommand");
    apply(new DeleteSwitchItEvent(command.getSwitchItId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignOpenToSwitchItCommand command) throws Exception {
    LOGGER.info("Handling command AssignOpenToSwitchItCommand");

    if (open != null && open.getBooleanProxyId() == command.getAssignment().getBooleanProxyId())
      throw new ProcessingException(
          "Open already assigned with id " + command.getAssignment().getBooleanProxyId());

    apply(new AssignOpenToSwitchItEvent(command.getSwitchItId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignOpenFromSwitchItCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignOpenFromSwitchItCommand");

    if (open == null) throw new ProcessingException("Open already has nothing assigned.");

    apply(new UnAssignOpenFromSwitchItEvent(command.getSwitchItId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateSwitchItEvent event) {
    LOGGER.info("Event sourcing CreateSwitchItEvent");
    this.switchItId = event.getSwitchItId();
  }

  @EventSourcingHandler
  void on(UpdateSwitchItEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.open = event.getOpen();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignOpenToSwitchItEvent event) {
    LOGGER.info("Event sourcing AssignOpenToSwitchItEvent");
    this.open = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignOpenFromSwitchItEvent event) {
    LOGGER.info("Event sourcing UnAssignOpenFromSwitchItEvent");
    this.open = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID switchItId;

  private BooleanProxy open = null;

  private static final Logger LOGGER = Logger.getLogger(SwitchItAggregate.class.getName());
}
