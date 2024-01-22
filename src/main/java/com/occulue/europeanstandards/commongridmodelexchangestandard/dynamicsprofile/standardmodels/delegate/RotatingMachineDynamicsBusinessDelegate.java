/**
 * ***************************************************************************** Turnstone Biologics
 * Confidential
 *
 * <p>2018 Turnstone Biologics All Rights Reserved.
 *
 * <p>This file is subject to the terms and conditions defined in file 'license.txt', which is part
 * of this source code package.
 *
 * <p>Contributors : Turnstone Biologics - General Release
 * ****************************************************************************
 */
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.validator.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.QueryUpdateEmitter;

/**
 * RotatingMachineDynamics business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of RotatingMachineDynamics related services in the case of a
 *       RotatingMachineDynamics business related service failing.
 *   <li>Exposes a simpler, uniform RotatingMachineDynamics interface to the business tier, making
 *       it easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill RotatingMachineDynamics
 *       business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class RotatingMachineDynamicsBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public RotatingMachineDynamicsBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * RotatingMachineDynamics Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return RotatingMachineDynamicsBusinessDelegate
   */
  public static RotatingMachineDynamicsBusinessDelegate getRotatingMachineDynamicsInstance() {
    return (new RotatingMachineDynamicsBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createRotatingMachineDynamics(
      CreateRotatingMachineDynamicsCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getRotatingMachineDynamicsId() == null)
        command.setRotatingMachineDynamicsId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      RotatingMachineDynamicsValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateRotatingMachineDynamicsCommand - by convention the future return value for
      // a create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateRotatingMachineDynamicsCommand of RotatingMachineDynamics is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create RotatingMachineDynamics - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateRotatingMachineDynamicsCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateRotatingMachineDynamics(
      UpdateRotatingMachineDynamicsCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      RotatingMachineDynamicsValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateRotatingMachineDynamicsCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save RotatingMachineDynamics - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteRotatingMachineDynamicsCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteRotatingMachineDynamicsCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      RotatingMachineDynamicsValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteRotatingMachineDynamicsCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete RotatingMachineDynamics using Id = "
              + command.getRotatingMachineDynamicsId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the RotatingMachineDynamics via RotatingMachineDynamicsFetchOneSummary
   *
   * @param summary RotatingMachineDynamicsFetchOneSummary
   * @return RotatingMachineDynamicsFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public RotatingMachineDynamics getRotatingMachineDynamics(
      RotatingMachineDynamicsFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException(
          "RotatingMachineDynamicsFetchOneSummary arg cannot be null");

    RotatingMachineDynamics entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      RotatingMachineDynamicsValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a RotatingMachineDynamics
      // --------------------------------------
      CompletableFuture<RotatingMachineDynamics> futureEntity =
          queryGateway.query(
              new FindRotatingMachineDynamicsQuery(
                  new LoadRotatingMachineDynamicsFilter(summary.getRotatingMachineDynamicsId())),
              ResponseTypes.instanceOf(RotatingMachineDynamics.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate RotatingMachineDynamics with id "
              + summary.getRotatingMachineDynamicsId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all RotatingMachineDynamicss
   *
   * @return List<RotatingMachineDynamics>
   * @exception ProcessingException Thrown if any problems
   */
  public List<RotatingMachineDynamics> getAllRotatingMachineDynamics() throws ProcessingException {
    List<RotatingMachineDynamics> list = null;

    try {
      CompletableFuture<List<RotatingMachineDynamics>> futureList =
          queryGateway.query(
              new FindAllRotatingMachineDynamicsQuery(),
              ResponseTypes.multipleInstancesOf(RotatingMachineDynamics.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all RotatingMachineDynamics";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Damping on RotatingMachineDynamics
   *
   * @param command AssignDampingToRotatingMachineDynamicsCommand
   * @exception ProcessingException
   */
  public void assignDamping(AssignDampingToRotatingMachineDynamicsCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getRotatingMachineDynamicsId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    RotatingMachineDynamicsBusinessDelegate parentDelegate =
        RotatingMachineDynamicsBusinessDelegate.getRotatingMachineDynamicsInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      RotatingMachineDynamicsValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Simple_Float using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Damping on RotatingMachineDynamics
   *
   * @param command UnAssignDampingFromRotatingMachineDynamicsCommand
   * @exception ProcessingException
   */
  public void unAssignDamping(UnAssignDampingFromRotatingMachineDynamicsCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      RotatingMachineDynamicsValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Damping on RotatingMachineDynamics";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Inertia on RotatingMachineDynamics
   *
   * @param command AssignInertiaToRotatingMachineDynamicsCommand
   * @exception ProcessingException
   */
  public void assignInertia(AssignInertiaToRotatingMachineDynamicsCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getRotatingMachineDynamicsId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    RotatingMachineDynamicsBusinessDelegate parentDelegate =
        RotatingMachineDynamicsBusinessDelegate.getRotatingMachineDynamicsInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      RotatingMachineDynamicsValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Seconds using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Inertia on RotatingMachineDynamics
   *
   * @param command UnAssignInertiaFromRotatingMachineDynamicsCommand
   * @exception ProcessingException
   */
  public void unAssignInertia(UnAssignInertiaFromRotatingMachineDynamicsCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      RotatingMachineDynamicsValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Inertia on RotatingMachineDynamics";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign SaturationFactor on RotatingMachineDynamics
   *
   * @param command AssignSaturationFactorToRotatingMachineDynamicsCommand
   * @exception ProcessingException
   */
  public void assignSaturationFactor(AssignSaturationFactorToRotatingMachineDynamicsCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getRotatingMachineDynamicsId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    RotatingMachineDynamicsBusinessDelegate parentDelegate =
        RotatingMachineDynamicsBusinessDelegate.getRotatingMachineDynamicsInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      RotatingMachineDynamicsValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Simple_Float using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign SaturationFactor on RotatingMachineDynamics
   *
   * @param command UnAssignSaturationFactorFromRotatingMachineDynamicsCommand
   * @exception ProcessingException
   */
  public void unAssignSaturationFactor(
      UnAssignSaturationFactorFromRotatingMachineDynamicsCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      RotatingMachineDynamicsValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign SaturationFactor on RotatingMachineDynamics";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign SaturationFactor120 on RotatingMachineDynamics
   *
   * @param command AssignSaturationFactor120ToRotatingMachineDynamicsCommand
   * @exception ProcessingException
   */
  public void assignSaturationFactor120(
      AssignSaturationFactor120ToRotatingMachineDynamicsCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getRotatingMachineDynamicsId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    RotatingMachineDynamicsBusinessDelegate parentDelegate =
        RotatingMachineDynamicsBusinessDelegate.getRotatingMachineDynamicsInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      RotatingMachineDynamicsValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Simple_Float using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign SaturationFactor120 on RotatingMachineDynamics
   *
   * @param command UnAssignSaturationFactor120FromRotatingMachineDynamicsCommand
   * @exception ProcessingException
   */
  public void unAssignSaturationFactor120(
      UnAssignSaturationFactor120FromRotatingMachineDynamicsCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      RotatingMachineDynamicsValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign SaturationFactor120 on RotatingMachineDynamics";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign StatorLeakageReactance on RotatingMachineDynamics
   *
   * @param command AssignStatorLeakageReactanceToRotatingMachineDynamicsCommand
   * @exception ProcessingException
   */
  public void assignStatorLeakageReactance(
      AssignStatorLeakageReactanceToRotatingMachineDynamicsCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getRotatingMachineDynamicsId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    RotatingMachineDynamicsBusinessDelegate parentDelegate =
        RotatingMachineDynamicsBusinessDelegate.getRotatingMachineDynamicsInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      RotatingMachineDynamicsValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get PU using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign StatorLeakageReactance on RotatingMachineDynamics
   *
   * @param command UnAssignStatorLeakageReactanceFromRotatingMachineDynamicsCommand
   * @exception ProcessingException
   */
  public void unAssignStatorLeakageReactance(
      UnAssignStatorLeakageReactanceFromRotatingMachineDynamicsCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      RotatingMachineDynamicsValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign StatorLeakageReactance on RotatingMachineDynamics";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign StatorResistance on RotatingMachineDynamics
   *
   * @param command AssignStatorResistanceToRotatingMachineDynamicsCommand
   * @exception ProcessingException
   */
  public void assignStatorResistance(AssignStatorResistanceToRotatingMachineDynamicsCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getRotatingMachineDynamicsId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    RotatingMachineDynamicsBusinessDelegate parentDelegate =
        RotatingMachineDynamicsBusinessDelegate.getRotatingMachineDynamicsInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      RotatingMachineDynamicsValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get PU using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign StatorResistance on RotatingMachineDynamics
   *
   * @param command UnAssignStatorResistanceFromRotatingMachineDynamicsCommand
   * @exception ProcessingException
   */
  public void unAssignStatorResistance(
      UnAssignStatorResistanceFromRotatingMachineDynamicsCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      RotatingMachineDynamicsValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign StatorResistance on RotatingMachineDynamics";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return RotatingMachineDynamics
   */
  private RotatingMachineDynamics load(UUID id) throws ProcessingException {
    rotatingMachineDynamics =
        RotatingMachineDynamicsBusinessDelegate.getRotatingMachineDynamicsInstance()
            .getRotatingMachineDynamics(new RotatingMachineDynamicsFetchOneSummary(id));
    return rotatingMachineDynamics;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private RotatingMachineDynamics rotatingMachineDynamics = null;
  private static final Logger LOGGER =
      Logger.getLogger(RotatingMachineDynamicsBusinessDelegate.class.getName());
}
