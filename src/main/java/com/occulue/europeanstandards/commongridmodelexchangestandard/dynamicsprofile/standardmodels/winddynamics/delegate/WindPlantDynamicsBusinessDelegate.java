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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.validator.*;
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
 * WindPlantDynamics business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of WindPlantDynamics related services in the case of a
 *       WindPlantDynamics business related service failing.
 *   <li>Exposes a simpler, uniform WindPlantDynamics interface to the business tier, making it easy
 *       for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill WindPlantDynamics business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class WindPlantDynamicsBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public WindPlantDynamicsBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * WindPlantDynamics Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return WindPlantDynamicsBusinessDelegate
   */
  public static WindPlantDynamicsBusinessDelegate getWindPlantDynamicsInstance() {
    return (new WindPlantDynamicsBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createWindPlantDynamics(CreateWindPlantDynamicsCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getWindPlantDynamicsId() == null)
        command.setWindPlantDynamicsId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindPlantDynamicsValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateWindPlantDynamicsCommand - by convention the future return value for a
      // create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateWindPlantDynamicsCommand of WindPlantDynamics is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create WindPlantDynamics - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateWindPlantDynamicsCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateWindPlantDynamics(UpdateWindPlantDynamicsCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      WindPlantDynamicsValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateWindPlantDynamicsCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save WindPlantDynamics - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteWindPlantDynamicsCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteWindPlantDynamicsCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindPlantDynamicsValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteWindPlantDynamicsCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete WindPlantDynamics using Id = " + command.getWindPlantDynamicsId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the WindPlantDynamics via WindPlantDynamicsFetchOneSummary
   *
   * @param summary WindPlantDynamicsFetchOneSummary
   * @return WindPlantDynamicsFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public WindPlantDynamics getWindPlantDynamics(WindPlantDynamicsFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("WindPlantDynamicsFetchOneSummary arg cannot be null");

    WindPlantDynamics entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      WindPlantDynamicsValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a WindPlantDynamics
      // --------------------------------------
      CompletableFuture<WindPlantDynamics> futureEntity =
          queryGateway.query(
              new FindWindPlantDynamicsQuery(
                  new LoadWindPlantDynamicsFilter(summary.getWindPlantDynamicsId())),
              ResponseTypes.instanceOf(WindPlantDynamics.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate WindPlantDynamics with id " + summary.getWindPlantDynamicsId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all WindPlantDynamicss
   *
   * @return List<WindPlantDynamics>
   * @exception ProcessingException Thrown if any problems
   */
  public List<WindPlantDynamics> getAllWindPlantDynamics() throws ProcessingException {
    List<WindPlantDynamics> list = null;

    try {
      CompletableFuture<List<WindPlantDynamics>> futureList =
          queryGateway.query(
              new FindAllWindPlantDynamicsQuery(),
              ResponseTypes.multipleInstancesOf(WindPlantDynamics.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all WindPlantDynamics";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign WindPlantDynamics on WindPlantDynamics
   *
   * @param command AssignWindPlantDynamicsToWindPlantDynamicsCommand
   * @exception ProcessingException
   */
  public void assignWindPlantDynamics(AssignWindPlantDynamicsToWindPlantDynamicsCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindPlantDynamicsId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
            .winddynamics.delegate.WindPlantDynamicsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile
                .standardmodels.winddynamics.delegate.WindPlantDynamicsBusinessDelegate
                .getWindPlantDynamicsInstance();
    WindPlantDynamicsBusinessDelegate parentDelegate =
        WindPlantDynamicsBusinessDelegate.getWindPlantDynamicsInstance();
    UUID childId = command.getAssignment().getWindPlantDynamicsId();
    WindPlantDynamics child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindPlantDynamicsValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get WindPlantDynamics using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign WindPlantDynamics on WindPlantDynamics
   *
   * @param command UnAssignWindPlantDynamicsFromWindPlantDynamicsCommand
   * @exception ProcessingException
   */
  public void unAssignWindPlantDynamics(
      UnAssignWindPlantDynamicsFromWindPlantDynamicsCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindPlantDynamicsValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign WindPlantDynamics on WindPlantDynamics";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return WindPlantDynamics
   */
  private WindPlantDynamics load(UUID id) throws ProcessingException {
    windPlantDynamics =
        WindPlantDynamicsBusinessDelegate.getWindPlantDynamicsInstance()
            .getWindPlantDynamics(new WindPlantDynamicsFetchOneSummary(id));
    return windPlantDynamics;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private WindPlantDynamics windPlantDynamics = null;
  private static final Logger LOGGER =
      Logger.getLogger(WindPlantDynamicsBusinessDelegate.class.getName());
}
