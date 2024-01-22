package com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile.statevariables.aggregate;

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
 * Aggregate handler for SvShuntCompensatorSections as outlined for the CQRS pattern, all write
 * responsibilities related to SvShuntCompensatorSections are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class SvShuntCompensatorSectionsAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public SvShuntCompensatorSectionsAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public SvShuntCompensatorSectionsAggregate(CreateSvShuntCompensatorSectionsCommand command)
      throws Exception {
    LOGGER.info("Handling command CreateSvShuntCompensatorSectionsCommand");
    CreateSvShuntCompensatorSectionsEvent event =
        new CreateSvShuntCompensatorSectionsEvent(command.getSvShuntCompensatorSectionsId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateSvShuntCompensatorSectionsCommand command) throws Exception {
    LOGGER.info("handling command UpdateSvShuntCompensatorSectionsCommand");
    UpdateSvShuntCompensatorSectionsEvent event =
        new UpdateSvShuntCompensatorSectionsEvent(
            command.getSvShuntCompensatorSectionsId(),
            command.getSections(),
            command.getSvShuntCompensatorSections());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteSvShuntCompensatorSectionsCommand command) throws Exception {
    LOGGER.info("Handling command DeleteSvShuntCompensatorSectionsCommand");
    apply(new DeleteSvShuntCompensatorSectionsEvent(command.getSvShuntCompensatorSectionsId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignSectionsToSvShuntCompensatorSectionsCommand command) throws Exception {
    LOGGER.info("Handling command AssignSectionsToSvShuntCompensatorSectionsCommand");

    if (sections != null
        && sections.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Sections already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignSectionsToSvShuntCompensatorSectionsEvent(
            command.getSvShuntCompensatorSectionsId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSectionsFromSvShuntCompensatorSectionsCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignSectionsFromSvShuntCompensatorSectionsCommand");

    if (sections == null) throw new ProcessingException("Sections already has nothing assigned.");

    apply(
        new UnAssignSectionsFromSvShuntCompensatorSectionsEvent(
            command.getSvShuntCompensatorSectionsId()));
  }

  @CommandHandler
  public void handle(AssignSvShuntCompensatorSectionsToSvShuntCompensatorSectionsCommand command)
      throws Exception {
    LOGGER.info(
        "Handling command AssignSvShuntCompensatorSectionsToSvShuntCompensatorSectionsCommand");

    if (svShuntCompensatorSections != null
        && svShuntCompensatorSections.getSvShuntCompensatorSectionsId()
            == command.getAssignment().getSvShuntCompensatorSectionsId())
      throw new ProcessingException(
          "SvShuntCompensatorSections already assigned with id "
              + command.getAssignment().getSvShuntCompensatorSectionsId());

    apply(
        new AssignSvShuntCompensatorSectionsToSvShuntCompensatorSectionsEvent(
            command.getSvShuntCompensatorSectionsId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(
      UnAssignSvShuntCompensatorSectionsFromSvShuntCompensatorSectionsCommand command)
      throws Exception {
    LOGGER.info(
        "Handlign command UnAssignSvShuntCompensatorSectionsFromSvShuntCompensatorSectionsCommand");

    if (svShuntCompensatorSections == null)
      throw new ProcessingException("SvShuntCompensatorSections already has nothing assigned.");

    apply(
        new UnAssignSvShuntCompensatorSectionsFromSvShuntCompensatorSectionsEvent(
            command.getSvShuntCompensatorSectionsId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateSvShuntCompensatorSectionsEvent event) {
    LOGGER.info("Event sourcing CreateSvShuntCompensatorSectionsEvent");
    this.svShuntCompensatorSectionsId = event.getSvShuntCompensatorSectionsId();
  }

  @EventSourcingHandler
  void on(UpdateSvShuntCompensatorSectionsEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.sections = event.getSections();
    this.svShuntCompensatorSections = event.getSvShuntCompensatorSections();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignSectionsToSvShuntCompensatorSectionsEvent event) {
    LOGGER.info("Event sourcing AssignSectionsToSvShuntCompensatorSectionsEvent");
    this.sections = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSectionsFromSvShuntCompensatorSectionsEvent event) {
    LOGGER.info("Event sourcing UnAssignSectionsFromSvShuntCompensatorSectionsEvent");
    this.sections = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSvShuntCompensatorSectionsToSvShuntCompensatorSectionsEvent event) {
    LOGGER.info("Event sourcing AssignSvShuntCompensatorSectionsToSvShuntCompensatorSectionsEvent");
    this.svShuntCompensatorSections = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSvShuntCompensatorSectionsFromSvShuntCompensatorSectionsEvent event) {
    LOGGER.info(
        "Event sourcing UnAssignSvShuntCompensatorSectionsFromSvShuntCompensatorSectionsEvent");
    this.svShuntCompensatorSections = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID svShuntCompensatorSectionsId;

  private Simple_Float sections = null;
  private SvShuntCompensatorSections svShuntCompensatorSections = null;

  private static final Logger LOGGER =
      Logger.getLogger(SvShuntCompensatorSectionsAggregate.class.getName());
}
