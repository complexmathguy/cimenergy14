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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.synchronousmachinedynamics.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.synchronousmachinedynamics.validator.*;
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
 * SynchronousMachineDynamics business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of SynchronousMachineDynamics related services in the case of a
 *       SynchronousMachineDynamics business related service failing.
 *   <li>Exposes a simpler, uniform SynchronousMachineDynamics interface to the business tier,
 *       making it easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill SynchronousMachineDynamics
 *       business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class SynchronousMachineDynamicsBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public SynchronousMachineDynamicsBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * SynchronousMachineDynamics Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return SynchronousMachineDynamicsBusinessDelegate
   */
  public static SynchronousMachineDynamicsBusinessDelegate getSynchronousMachineDynamicsInstance() {
    return (new SynchronousMachineDynamicsBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createSynchronousMachineDynamics(
      CreateSynchronousMachineDynamicsCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getSynchronousMachineDynamicsId() == null)
        command.setSynchronousMachineDynamicsId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      SynchronousMachineDynamicsValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateSynchronousMachineDynamicsCommand - by convention the future return value
      // for a create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateSynchronousMachineDynamicsCommand of SynchronousMachineDynamics is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create SynchronousMachineDynamics - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateSynchronousMachineDynamicsCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateSynchronousMachineDynamics(
      UpdateSynchronousMachineDynamicsCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      SynchronousMachineDynamicsValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateSynchronousMachineDynamicsCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save SynchronousMachineDynamics - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteSynchronousMachineDynamicsCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteSynchronousMachineDynamicsCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SynchronousMachineDynamicsValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteSynchronousMachineDynamicsCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete SynchronousMachineDynamics using Id = "
              + command.getSynchronousMachineDynamicsId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the SynchronousMachineDynamics via SynchronousMachineDynamicsFetchOneSummary
   *
   * @param summary SynchronousMachineDynamicsFetchOneSummary
   * @return SynchronousMachineDynamicsFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public SynchronousMachineDynamics getSynchronousMachineDynamics(
      SynchronousMachineDynamicsFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException(
          "SynchronousMachineDynamicsFetchOneSummary arg cannot be null");

    SynchronousMachineDynamics entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      SynchronousMachineDynamicsValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a SynchronousMachineDynamics
      // --------------------------------------
      CompletableFuture<SynchronousMachineDynamics> futureEntity =
          queryGateway.query(
              new FindSynchronousMachineDynamicsQuery(
                  new LoadSynchronousMachineDynamicsFilter(
                      summary.getSynchronousMachineDynamicsId())),
              ResponseTypes.instanceOf(SynchronousMachineDynamics.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate SynchronousMachineDynamics with id "
              + summary.getSynchronousMachineDynamicsId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all SynchronousMachineDynamicss
   *
   * @return List<SynchronousMachineDynamics>
   * @exception ProcessingException Thrown if any problems
   */
  public List<SynchronousMachineDynamics> getAllSynchronousMachineDynamics()
      throws ProcessingException {
    List<SynchronousMachineDynamics> list = null;

    try {
      CompletableFuture<List<SynchronousMachineDynamics>> futureList =
          queryGateway.query(
              new FindAllSynchronousMachineDynamicsQuery(),
              ResponseTypes.multipleInstancesOf(SynchronousMachineDynamics.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all SynchronousMachineDynamics";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign SynchronousMachineDynamics on SynchronousMachineDynamics
   *
   * @param command AssignSynchronousMachineDynamicsToSynchronousMachineDynamicsCommand
   * @exception ProcessingException
   */
  public void assignSynchronousMachineDynamics(
      AssignSynchronousMachineDynamicsToSynchronousMachineDynamicsCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSynchronousMachineDynamicsId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
            .synchronousmachinedynamics.delegate.SynchronousMachineDynamicsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile
                .standardmodels.synchronousmachinedynamics.delegate
                .SynchronousMachineDynamicsBusinessDelegate.getSynchronousMachineDynamicsInstance();
    SynchronousMachineDynamicsBusinessDelegate parentDelegate =
        SynchronousMachineDynamicsBusinessDelegate.getSynchronousMachineDynamicsInstance();
    UUID childId = command.getAssignment().getSynchronousMachineDynamicsId();
    SynchronousMachineDynamics child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SynchronousMachineDynamicsValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get SynchronousMachineDynamics using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign SynchronousMachineDynamics on SynchronousMachineDynamics
   *
   * @param command UnAssignSynchronousMachineDynamicsFromSynchronousMachineDynamicsCommand
   * @exception ProcessingException
   */
  public void unAssignSynchronousMachineDynamics(
      UnAssignSynchronousMachineDynamicsFromSynchronousMachineDynamicsCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SynchronousMachineDynamicsValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg =
          "Failed to unassign SynchronousMachineDynamics on SynchronousMachineDynamics";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return SynchronousMachineDynamics
   */
  private SynchronousMachineDynamics load(UUID id) throws ProcessingException {
    synchronousMachineDynamics =
        SynchronousMachineDynamicsBusinessDelegate.getSynchronousMachineDynamicsInstance()
            .getSynchronousMachineDynamics(new SynchronousMachineDynamicsFetchOneSummary(id));
    return synchronousMachineDynamics;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private SynchronousMachineDynamics synchronousMachineDynamics = null;
  private static final Logger LOGGER =
      Logger.getLogger(SynchronousMachineDynamicsBusinessDelegate.class.getName());
}
