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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.excitationsystemdynamics.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.excitationsystemdynamics.validator.*;
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
 * ExcitationSystemDynamics business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of ExcitationSystemDynamics related services in the case of a
 *       ExcitationSystemDynamics business related service failing.
 *   <li>Exposes a simpler, uniform ExcitationSystemDynamics interface to the business tier, making
 *       it easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill ExcitationSystemDynamics
 *       business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class ExcitationSystemDynamicsBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public ExcitationSystemDynamicsBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * ExcitationSystemDynamics Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return ExcitationSystemDynamicsBusinessDelegate
   */
  public static ExcitationSystemDynamicsBusinessDelegate getExcitationSystemDynamicsInstance() {
    return (new ExcitationSystemDynamicsBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createExcitationSystemDynamics(
      CreateExcitationSystemDynamicsCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getExcitationSystemDynamicsId() == null)
        command.setExcitationSystemDynamicsId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcitationSystemDynamicsValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateExcitationSystemDynamicsCommand - by convention the future return value for
      // a create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateExcitationSystemDynamicsCommand of ExcitationSystemDynamics is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create ExcitationSystemDynamics - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateExcitationSystemDynamicsCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateExcitationSystemDynamics(
      UpdateExcitationSystemDynamicsCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      ExcitationSystemDynamicsValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateExcitationSystemDynamicsCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save ExcitationSystemDynamics - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteExcitationSystemDynamicsCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteExcitationSystemDynamicsCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcitationSystemDynamicsValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteExcitationSystemDynamicsCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete ExcitationSystemDynamics using Id = "
              + command.getExcitationSystemDynamicsId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the ExcitationSystemDynamics via ExcitationSystemDynamicsFetchOneSummary
   *
   * @param summary ExcitationSystemDynamicsFetchOneSummary
   * @return ExcitationSystemDynamicsFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public ExcitationSystemDynamics getExcitationSystemDynamics(
      ExcitationSystemDynamicsFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException(
          "ExcitationSystemDynamicsFetchOneSummary arg cannot be null");

    ExcitationSystemDynamics entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      ExcitationSystemDynamicsValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a ExcitationSystemDynamics
      // --------------------------------------
      CompletableFuture<ExcitationSystemDynamics> futureEntity =
          queryGateway.query(
              new FindExcitationSystemDynamicsQuery(
                  new LoadExcitationSystemDynamicsFilter(summary.getExcitationSystemDynamicsId())),
              ResponseTypes.instanceOf(ExcitationSystemDynamics.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate ExcitationSystemDynamics with id "
              + summary.getExcitationSystemDynamicsId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all ExcitationSystemDynamicss
   *
   * @return List<ExcitationSystemDynamics>
   * @exception ProcessingException Thrown if any problems
   */
  public List<ExcitationSystemDynamics> getAllExcitationSystemDynamics()
      throws ProcessingException {
    List<ExcitationSystemDynamics> list = null;

    try {
      CompletableFuture<List<ExcitationSystemDynamics>> futureList =
          queryGateway.query(
              new FindAllExcitationSystemDynamicsQuery(),
              ResponseTypes.multipleInstancesOf(ExcitationSystemDynamics.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all ExcitationSystemDynamics";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign ExcitationSystemDynamics on ExcitationSystemDynamics
   *
   * @param command AssignExcitationSystemDynamicsToExcitationSystemDynamicsCommand
   * @exception ProcessingException
   */
  public void assignExcitationSystemDynamics(
      AssignExcitationSystemDynamicsToExcitationSystemDynamicsCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExcitationSystemDynamicsId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
            .excitationsystemdynamics.delegate.ExcitationSystemDynamicsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile
                .standardmodels.excitationsystemdynamics.delegate
                .ExcitationSystemDynamicsBusinessDelegate.getExcitationSystemDynamicsInstance();
    ExcitationSystemDynamicsBusinessDelegate parentDelegate =
        ExcitationSystemDynamicsBusinessDelegate.getExcitationSystemDynamicsInstance();
    UUID childId = command.getAssignment().getExcitationSystemDynamicsId();
    ExcitationSystemDynamics child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExcitationSystemDynamicsValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get ExcitationSystemDynamics using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign ExcitationSystemDynamics on ExcitationSystemDynamics
   *
   * @param command UnAssignExcitationSystemDynamicsFromExcitationSystemDynamicsCommand
   * @exception ProcessingException
   */
  public void unAssignExcitationSystemDynamics(
      UnAssignExcitationSystemDynamicsFromExcitationSystemDynamicsCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExcitationSystemDynamicsValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign ExcitationSystemDynamics on ExcitationSystemDynamics";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return ExcitationSystemDynamics
   */
  private ExcitationSystemDynamics load(UUID id) throws ProcessingException {
    excitationSystemDynamics =
        ExcitationSystemDynamicsBusinessDelegate.getExcitationSystemDynamicsInstance()
            .getExcitationSystemDynamics(new ExcitationSystemDynamicsFetchOneSummary(id));
    return excitationSystemDynamics;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private ExcitationSystemDynamics excitationSystemDynamics = null;
  private static final Logger LOGGER =
      Logger.getLogger(ExcitationSystemDynamicsBusinessDelegate.class.getName());
}
