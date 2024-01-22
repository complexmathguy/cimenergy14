package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardinterconnections.aggregate;

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
 * Aggregate handler for RemoteInputSignal as outlined for the CQRS pattern, all write
 * responsibilities related to RemoteInputSignal are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class RemoteInputSignalAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public RemoteInputSignalAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public RemoteInputSignalAggregate(CreateRemoteInputSignalCommand command) throws Exception {
    LOGGER.info("Handling command CreateRemoteInputSignalCommand");
    CreateRemoteInputSignalEvent event =
        new CreateRemoteInputSignalEvent(
            command.getRemoteInputSignalId(), command.getRemoteSignalType());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateRemoteInputSignalCommand command) throws Exception {
    LOGGER.info("handling command UpdateRemoteInputSignalCommand");
    UpdateRemoteInputSignalEvent event =
        new UpdateRemoteInputSignalEvent(
            command.getRemoteInputSignalId(),
            command.getRemoteSignalType(),
            command.getRemoteInputSignal());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteRemoteInputSignalCommand command) throws Exception {
    LOGGER.info("Handling command DeleteRemoteInputSignalCommand");
    apply(new DeleteRemoteInputSignalEvent(command.getRemoteInputSignalId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands

  // multiple association commands
  @CommandHandler
  public void handle(AssignRemoteInputSignalToRemoteInputSignalCommand command) throws Exception {
    LOGGER.info("Handling command AssignRemoteInputSignalToRemoteInputSignalCommand");

    if (remoteInputSignal.contains(command.getAddTo()))
      throw new ProcessingException(
          "RemoteInputSignal already contains an entity with id "
              + command.getAddTo().getRemoteInputSignalId());

    apply(
        new AssignRemoteInputSignalToRemoteInputSignalEvent(
            command.getRemoteInputSignalId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemoveRemoteInputSignalFromRemoteInputSignalCommand command) throws Exception {
    LOGGER.info("Handling command RemoveRemoteInputSignalFromRemoteInputSignalCommand");

    if (!remoteInputSignal.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "RemoteInputSignal does not contain an entity with id "
              + command.getRemoveFrom().getRemoteInputSignalId());

    apply(
        new RemoveRemoteInputSignalFromRemoteInputSignalEvent(
            command.getRemoteInputSignalId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateRemoteInputSignalEvent event) {
    LOGGER.info("Event sourcing CreateRemoteInputSignalEvent");
    this.remoteInputSignalId = event.getRemoteInputSignalId();
    this.remoteSignalType = event.getRemoteSignalType();
  }

  @EventSourcingHandler
  void on(UpdateRemoteInputSignalEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.remoteSignalType = event.getRemoteSignalType();
    this.remoteInputSignal = event.getRemoteInputSignal();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------

  // multiple associations
  @EventSourcingHandler
  void on(AssignRemoteInputSignalToRemoteInputSignalEvent event) {
    LOGGER.info("Event sourcing AssignRemoteInputSignalToRemoteInputSignalEvent");
    this.remoteInputSignal.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveRemoteInputSignalFromRemoteInputSignalEvent event) {
    LOGGER.info("Event sourcing RemoveRemoteInputSignalFromRemoteInputSignalEvent");
    this.remoteInputSignal.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID remoteInputSignalId;

  private RemoteSignalKind remoteSignalType;
  private Set<RemoteInputSignal> remoteInputSignal = new HashSet<>();

  private static final Logger LOGGER = Logger.getLogger(RemoteInputSignalAggregate.class.getName());
}
