package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.aggregate;

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
 * Aggregate handler for RotatingMachineDynamics as outlined for the CQRS pattern, all write
 * responsibilities related to RotatingMachineDynamics are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class RotatingMachineDynamicsAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public RotatingMachineDynamicsAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public RotatingMachineDynamicsAggregate(CreateRotatingMachineDynamicsCommand command)
      throws Exception {
    LOGGER.info("Handling command CreateRotatingMachineDynamicsCommand");
    CreateRotatingMachineDynamicsEvent event =
        new CreateRotatingMachineDynamicsEvent(command.getRotatingMachineDynamicsId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateRotatingMachineDynamicsCommand command) throws Exception {
    LOGGER.info("handling command UpdateRotatingMachineDynamicsCommand");
    UpdateRotatingMachineDynamicsEvent event =
        new UpdateRotatingMachineDynamicsEvent(
            command.getRotatingMachineDynamicsId(),
            command.getDamping(),
            command.getInertia(),
            command.getSaturationFactor(),
            command.getSaturationFactor120(),
            command.getStatorLeakageReactance(),
            command.getStatorResistance());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteRotatingMachineDynamicsCommand command) throws Exception {
    LOGGER.info("Handling command DeleteRotatingMachineDynamicsCommand");
    apply(new DeleteRotatingMachineDynamicsEvent(command.getRotatingMachineDynamicsId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignDampingToRotatingMachineDynamicsCommand command) throws Exception {
    LOGGER.info("Handling command AssignDampingToRotatingMachineDynamicsCommand");

    if (damping != null
        && damping.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "Damping already assigned with id " + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignDampingToRotatingMachineDynamicsEvent(
            command.getRotatingMachineDynamicsId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignDampingFromRotatingMachineDynamicsCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignDampingFromRotatingMachineDynamicsCommand");

    if (damping == null) throw new ProcessingException("Damping already has nothing assigned.");

    apply(
        new UnAssignDampingFromRotatingMachineDynamicsEvent(
            command.getRotatingMachineDynamicsId()));
  }

  @CommandHandler
  public void handle(AssignInertiaToRotatingMachineDynamicsCommand command) throws Exception {
    LOGGER.info("Handling command AssignInertiaToRotatingMachineDynamicsCommand");

    if (inertia != null && inertia.getSecondsId() == command.getAssignment().getSecondsId())
      throw new ProcessingException(
          "Inertia already assigned with id " + command.getAssignment().getSecondsId());

    apply(
        new AssignInertiaToRotatingMachineDynamicsEvent(
            command.getRotatingMachineDynamicsId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignInertiaFromRotatingMachineDynamicsCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignInertiaFromRotatingMachineDynamicsCommand");

    if (inertia == null) throw new ProcessingException("Inertia already has nothing assigned.");

    apply(
        new UnAssignInertiaFromRotatingMachineDynamicsEvent(
            command.getRotatingMachineDynamicsId()));
  }

  @CommandHandler
  public void handle(AssignSaturationFactorToRotatingMachineDynamicsCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignSaturationFactorToRotatingMachineDynamicsCommand");

    if (saturationFactor != null
        && saturationFactor.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "SaturationFactor already assigned with id "
              + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignSaturationFactorToRotatingMachineDynamicsEvent(
            command.getRotatingMachineDynamicsId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSaturationFactorFromRotatingMachineDynamicsCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignSaturationFactorFromRotatingMachineDynamicsCommand");

    if (saturationFactor == null)
      throw new ProcessingException("SaturationFactor already has nothing assigned.");

    apply(
        new UnAssignSaturationFactorFromRotatingMachineDynamicsEvent(
            command.getRotatingMachineDynamicsId()));
  }

  @CommandHandler
  public void handle(AssignSaturationFactor120ToRotatingMachineDynamicsCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignSaturationFactor120ToRotatingMachineDynamicsCommand");

    if (saturationFactor120 != null
        && saturationFactor120.getSimple_FloatId() == command.getAssignment().getSimple_FloatId())
      throw new ProcessingException(
          "SaturationFactor120 already assigned with id "
              + command.getAssignment().getSimple_FloatId());

    apply(
        new AssignSaturationFactor120ToRotatingMachineDynamicsEvent(
            command.getRotatingMachineDynamicsId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignSaturationFactor120FromRotatingMachineDynamicsCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignSaturationFactor120FromRotatingMachineDynamicsCommand");

    if (saturationFactor120 == null)
      throw new ProcessingException("SaturationFactor120 already has nothing assigned.");

    apply(
        new UnAssignSaturationFactor120FromRotatingMachineDynamicsEvent(
            command.getRotatingMachineDynamicsId()));
  }

  @CommandHandler
  public void handle(AssignStatorLeakageReactanceToRotatingMachineDynamicsCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignStatorLeakageReactanceToRotatingMachineDynamicsCommand");

    if (statorLeakageReactance != null
        && statorLeakageReactance.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "StatorLeakageReactance already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignStatorLeakageReactanceToRotatingMachineDynamicsEvent(
            command.getRotatingMachineDynamicsId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignStatorLeakageReactanceFromRotatingMachineDynamicsCommand command)
      throws Exception {
    LOGGER.info(
        "Handlign command UnAssignStatorLeakageReactanceFromRotatingMachineDynamicsCommand");

    if (statorLeakageReactance == null)
      throw new ProcessingException("StatorLeakageReactance already has nothing assigned.");

    apply(
        new UnAssignStatorLeakageReactanceFromRotatingMachineDynamicsEvent(
            command.getRotatingMachineDynamicsId()));
  }

  @CommandHandler
  public void handle(AssignStatorResistanceToRotatingMachineDynamicsCommand command)
      throws Exception {
    LOGGER.info("Handling command AssignStatorResistanceToRotatingMachineDynamicsCommand");

    if (statorResistance != null && statorResistance.getPUId() == command.getAssignment().getPUId())
      throw new ProcessingException(
          "StatorResistance already assigned with id " + command.getAssignment().getPUId());

    apply(
        new AssignStatorResistanceToRotatingMachineDynamicsEvent(
            command.getRotatingMachineDynamicsId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignStatorResistanceFromRotatingMachineDynamicsCommand command)
      throws Exception {
    LOGGER.info("Handlign command UnAssignStatorResistanceFromRotatingMachineDynamicsCommand");

    if (statorResistance == null)
      throw new ProcessingException("StatorResistance already has nothing assigned.");

    apply(
        new UnAssignStatorResistanceFromRotatingMachineDynamicsEvent(
            command.getRotatingMachineDynamicsId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateRotatingMachineDynamicsEvent event) {
    LOGGER.info("Event sourcing CreateRotatingMachineDynamicsEvent");
    this.rotatingMachineDynamicsId = event.getRotatingMachineDynamicsId();
  }

  @EventSourcingHandler
  void on(UpdateRotatingMachineDynamicsEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.damping = event.getDamping();
    this.inertia = event.getInertia();
    this.saturationFactor = event.getSaturationFactor();
    this.saturationFactor120 = event.getSaturationFactor120();
    this.statorLeakageReactance = event.getStatorLeakageReactance();
    this.statorResistance = event.getStatorResistance();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignDampingToRotatingMachineDynamicsEvent event) {
    LOGGER.info("Event sourcing AssignDampingToRotatingMachineDynamicsEvent");
    this.damping = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignDampingFromRotatingMachineDynamicsEvent event) {
    LOGGER.info("Event sourcing UnAssignDampingFromRotatingMachineDynamicsEvent");
    this.damping = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignInertiaToRotatingMachineDynamicsEvent event) {
    LOGGER.info("Event sourcing AssignInertiaToRotatingMachineDynamicsEvent");
    this.inertia = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignInertiaFromRotatingMachineDynamicsEvent event) {
    LOGGER.info("Event sourcing UnAssignInertiaFromRotatingMachineDynamicsEvent");
    this.inertia = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSaturationFactorToRotatingMachineDynamicsEvent event) {
    LOGGER.info("Event sourcing AssignSaturationFactorToRotatingMachineDynamicsEvent");
    this.saturationFactor = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSaturationFactorFromRotatingMachineDynamicsEvent event) {
    LOGGER.info("Event sourcing UnAssignSaturationFactorFromRotatingMachineDynamicsEvent");
    this.saturationFactor = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignSaturationFactor120ToRotatingMachineDynamicsEvent event) {
    LOGGER.info("Event sourcing AssignSaturationFactor120ToRotatingMachineDynamicsEvent");
    this.saturationFactor120 = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignSaturationFactor120FromRotatingMachineDynamicsEvent event) {
    LOGGER.info("Event sourcing UnAssignSaturationFactor120FromRotatingMachineDynamicsEvent");
    this.saturationFactor120 = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignStatorLeakageReactanceToRotatingMachineDynamicsEvent event) {
    LOGGER.info("Event sourcing AssignStatorLeakageReactanceToRotatingMachineDynamicsEvent");
    this.statorLeakageReactance = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignStatorLeakageReactanceFromRotatingMachineDynamicsEvent event) {
    LOGGER.info("Event sourcing UnAssignStatorLeakageReactanceFromRotatingMachineDynamicsEvent");
    this.statorLeakageReactance = null;
  }
  // single associations
  @EventSourcingHandler
  void on(AssignStatorResistanceToRotatingMachineDynamicsEvent event) {
    LOGGER.info("Event sourcing AssignStatorResistanceToRotatingMachineDynamicsEvent");
    this.statorResistance = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignStatorResistanceFromRotatingMachineDynamicsEvent event) {
    LOGGER.info("Event sourcing UnAssignStatorResistanceFromRotatingMachineDynamicsEvent");
    this.statorResistance = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID rotatingMachineDynamicsId;

  private Simple_Float damping = null;
  private Seconds inertia = null;
  private Simple_Float saturationFactor = null;
  private Simple_Float saturationFactor120 = null;
  private PU statorLeakageReactance = null;
  private PU statorResistance = null;

  private static final Logger LOGGER =
      Logger.getLogger(RotatingMachineDynamicsAggregate.class.getName());
}
