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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.turbineloadcontrollerdynamics.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.turbineloadcontrollerdynamics.validator.*;
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
 * TurbineLoadControllerDynamics business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of TurbineLoadControllerDynamics related services in the case of a
 *       TurbineLoadControllerDynamics business related service failing.
 *   <li>Exposes a simpler, uniform TurbineLoadControllerDynamics interface to the business tier,
 *       making it easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill
 *       TurbineLoadControllerDynamics business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class TurbineLoadControllerDynamicsBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public TurbineLoadControllerDynamicsBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * TurbineLoadControllerDynamics Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return TurbineLoadControllerDynamicsBusinessDelegate
   */
  public static TurbineLoadControllerDynamicsBusinessDelegate
      getTurbineLoadControllerDynamicsInstance() {
    return (new TurbineLoadControllerDynamicsBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createTurbineLoadControllerDynamics(
      CreateTurbineLoadControllerDynamicsCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getTurbineLoadControllerDynamicsId() == null)
        command.setTurbineLoadControllerDynamicsId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      TurbineLoadControllerDynamicsValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateTurbineLoadControllerDynamicsCommand - by convention the future return
      // value for a create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateTurbineLoadControllerDynamicsCommand of TurbineLoadControllerDynamics is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create TurbineLoadControllerDynamics - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateTurbineLoadControllerDynamicsCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateTurbineLoadControllerDynamics(
      UpdateTurbineLoadControllerDynamicsCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      TurbineLoadControllerDynamicsValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateTurbineLoadControllerDynamicsCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save TurbineLoadControllerDynamics - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteTurbineLoadControllerDynamicsCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteTurbineLoadControllerDynamicsCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TurbineLoadControllerDynamicsValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteTurbineLoadControllerDynamicsCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete TurbineLoadControllerDynamics using Id = "
              + command.getTurbineLoadControllerDynamicsId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the TurbineLoadControllerDynamics via
   * TurbineLoadControllerDynamicsFetchOneSummary
   *
   * @param summary TurbineLoadControllerDynamicsFetchOneSummary
   * @return TurbineLoadControllerDynamicsFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public TurbineLoadControllerDynamics getTurbineLoadControllerDynamics(
      TurbineLoadControllerDynamicsFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException(
          "TurbineLoadControllerDynamicsFetchOneSummary arg cannot be null");

    TurbineLoadControllerDynamics entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      TurbineLoadControllerDynamicsValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a TurbineLoadControllerDynamics
      // --------------------------------------
      CompletableFuture<TurbineLoadControllerDynamics> futureEntity =
          queryGateway.query(
              new FindTurbineLoadControllerDynamicsQuery(
                  new LoadTurbineLoadControllerDynamicsFilter(
                      summary.getTurbineLoadControllerDynamicsId())),
              ResponseTypes.instanceOf(TurbineLoadControllerDynamics.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate TurbineLoadControllerDynamics with id "
              + summary.getTurbineLoadControllerDynamicsId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all TurbineLoadControllerDynamicss
   *
   * @return List<TurbineLoadControllerDynamics>
   * @exception ProcessingException Thrown if any problems
   */
  public List<TurbineLoadControllerDynamics> getAllTurbineLoadControllerDynamics()
      throws ProcessingException {
    List<TurbineLoadControllerDynamics> list = null;

    try {
      CompletableFuture<List<TurbineLoadControllerDynamics>> futureList =
          queryGateway.query(
              new FindAllTurbineLoadControllerDynamicsQuery(),
              ResponseTypes.multipleInstancesOf(TurbineLoadControllerDynamics.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all TurbineLoadControllerDynamics";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign TurbineLoadControllerDynamics on TurbineLoadControllerDynamics
   *
   * @param command AssignTurbineLoadControllerDynamicsToTurbineLoadControllerDynamicsCommand
   * @exception ProcessingException
   */
  public void assignTurbineLoadControllerDynamics(
      AssignTurbineLoadControllerDynamicsToTurbineLoadControllerDynamicsCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getTurbineLoadControllerDynamicsId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
            .turbineloadcontrollerdynamics.delegate.TurbineLoadControllerDynamicsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile
                .standardmodels.turbineloadcontrollerdynamics.delegate
                .TurbineLoadControllerDynamicsBusinessDelegate
                .getTurbineLoadControllerDynamicsInstance();
    TurbineLoadControllerDynamicsBusinessDelegate parentDelegate =
        TurbineLoadControllerDynamicsBusinessDelegate.getTurbineLoadControllerDynamicsInstance();
    UUID childId = command.getAssignment().getTurbineLoadControllerDynamicsId();
    TurbineLoadControllerDynamics child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      TurbineLoadControllerDynamicsValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get TurbineLoadControllerDynamics using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign TurbineLoadControllerDynamics on TurbineLoadControllerDynamics
   *
   * @param command UnAssignTurbineLoadControllerDynamicsFromTurbineLoadControllerDynamicsCommand
   * @exception ProcessingException
   */
  public void unAssignTurbineLoadControllerDynamics(
      UnAssignTurbineLoadControllerDynamicsFromTurbineLoadControllerDynamicsCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TurbineLoadControllerDynamicsValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg =
          "Failed to unassign TurbineLoadControllerDynamics on TurbineLoadControllerDynamics";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return TurbineLoadControllerDynamics
   */
  private TurbineLoadControllerDynamics load(UUID id) throws ProcessingException {
    turbineLoadControllerDynamics =
        TurbineLoadControllerDynamicsBusinessDelegate.getTurbineLoadControllerDynamicsInstance()
            .getTurbineLoadControllerDynamics(new TurbineLoadControllerDynamicsFetchOneSummary(id));
    return turbineLoadControllerDynamics;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private TurbineLoadControllerDynamics turbineLoadControllerDynamics = null;
  private static final Logger LOGGER =
      Logger.getLogger(TurbineLoadControllerDynamicsBusinessDelegate.class.getName());
}
