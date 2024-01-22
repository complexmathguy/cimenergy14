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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.underexcitationlimiterdynamics.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.underexcitationlimiterdynamics.validator.*;
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
 * UnderexcitationLimiterDynamics business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of UnderexcitationLimiterDynamics related services in the case of a
 *       UnderexcitationLimiterDynamics business related service failing.
 *   <li>Exposes a simpler, uniform UnderexcitationLimiterDynamics interface to the business tier,
 *       making it easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill
 *       UnderexcitationLimiterDynamics business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class UnderexcitationLimiterDynamicsBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public UnderexcitationLimiterDynamicsBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * UnderexcitationLimiterDynamics Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return UnderexcitationLimiterDynamicsBusinessDelegate
   */
  public static UnderexcitationLimiterDynamicsBusinessDelegate
      getUnderexcitationLimiterDynamicsInstance() {
    return (new UnderexcitationLimiterDynamicsBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createUnderexcitationLimiterDynamics(
      CreateUnderexcitationLimiterDynamicsCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getUnderexcitationLimiterDynamicsId() == null)
        command.setUnderexcitationLimiterDynamicsId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcitationLimiterDynamicsValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateUnderexcitationLimiterDynamicsCommand - by convention the future return
      // value for a create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateUnderexcitationLimiterDynamicsCommand of UnderexcitationLimiterDynamics is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create UnderexcitationLimiterDynamics - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateUnderexcitationLimiterDynamicsCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateUnderexcitationLimiterDynamics(
      UpdateUnderexcitationLimiterDynamicsCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      UnderexcitationLimiterDynamicsValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateUnderexcitationLimiterDynamicsCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save UnderexcitationLimiterDynamics - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteUnderexcitationLimiterDynamicsCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteUnderexcitationLimiterDynamicsCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcitationLimiterDynamicsValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteUnderexcitationLimiterDynamicsCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete UnderexcitationLimiterDynamics using Id = "
              + command.getUnderexcitationLimiterDynamicsId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the UnderexcitationLimiterDynamics via
   * UnderexcitationLimiterDynamicsFetchOneSummary
   *
   * @param summary UnderexcitationLimiterDynamicsFetchOneSummary
   * @return UnderexcitationLimiterDynamicsFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public UnderexcitationLimiterDynamics getUnderexcitationLimiterDynamics(
      UnderexcitationLimiterDynamicsFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException(
          "UnderexcitationLimiterDynamicsFetchOneSummary arg cannot be null");

    UnderexcitationLimiterDynamics entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      UnderexcitationLimiterDynamicsValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a UnderexcitationLimiterDynamics
      // --------------------------------------
      CompletableFuture<UnderexcitationLimiterDynamics> futureEntity =
          queryGateway.query(
              new FindUnderexcitationLimiterDynamicsQuery(
                  new LoadUnderexcitationLimiterDynamicsFilter(
                      summary.getUnderexcitationLimiterDynamicsId())),
              ResponseTypes.instanceOf(UnderexcitationLimiterDynamics.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate UnderexcitationLimiterDynamics with id "
              + summary.getUnderexcitationLimiterDynamicsId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all UnderexcitationLimiterDynamicss
   *
   * @return List<UnderexcitationLimiterDynamics>
   * @exception ProcessingException Thrown if any problems
   */
  public List<UnderexcitationLimiterDynamics> getAllUnderexcitationLimiterDynamics()
      throws ProcessingException {
    List<UnderexcitationLimiterDynamics> list = null;

    try {
      CompletableFuture<List<UnderexcitationLimiterDynamics>> futureList =
          queryGateway.query(
              new FindAllUnderexcitationLimiterDynamicsQuery(),
              ResponseTypes.multipleInstancesOf(UnderexcitationLimiterDynamics.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all UnderexcitationLimiterDynamics";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign UnderexcitationLimiterDynamics on UnderexcitationLimiterDynamics
   *
   * @param command AssignUnderexcitationLimiterDynamicsToUnderexcitationLimiterDynamicsCommand
   * @exception ProcessingException
   */
  public void assignUnderexcitationLimiterDynamics(
      AssignUnderexcitationLimiterDynamicsToUnderexcitationLimiterDynamicsCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getUnderexcitationLimiterDynamicsId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
            .underexcitationlimiterdynamics.delegate.UnderexcitationLimiterDynamicsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile
                .standardmodels.underexcitationlimiterdynamics.delegate
                .UnderexcitationLimiterDynamicsBusinessDelegate
                .getUnderexcitationLimiterDynamicsInstance();
    UnderexcitationLimiterDynamicsBusinessDelegate parentDelegate =
        UnderexcitationLimiterDynamicsBusinessDelegate.getUnderexcitationLimiterDynamicsInstance();
    UUID childId = command.getAssignment().getUnderexcitationLimiterDynamicsId();
    UnderexcitationLimiterDynamics child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      UnderexcitationLimiterDynamicsValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get UnderexcitationLimiterDynamics using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign UnderexcitationLimiterDynamics on UnderexcitationLimiterDynamics
   *
   * @param command UnAssignUnderexcitationLimiterDynamicsFromUnderexcitationLimiterDynamicsCommand
   * @exception ProcessingException
   */
  public void unAssignUnderexcitationLimiterDynamics(
      UnAssignUnderexcitationLimiterDynamicsFromUnderexcitationLimiterDynamicsCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      UnderexcitationLimiterDynamicsValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg =
          "Failed to unassign UnderexcitationLimiterDynamics on UnderexcitationLimiterDynamics";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return UnderexcitationLimiterDynamics
   */
  private UnderexcitationLimiterDynamics load(UUID id) throws ProcessingException {
    underexcitationLimiterDynamics =
        UnderexcitationLimiterDynamicsBusinessDelegate.getUnderexcitationLimiterDynamicsInstance()
            .getUnderexcitationLimiterDynamics(
                new UnderexcitationLimiterDynamicsFetchOneSummary(id));
    return underexcitationLimiterDynamics;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private UnderexcitationLimiterDynamics underexcitationLimiterDynamics = null;
  private static final Logger LOGGER =
      Logger.getLogger(UnderexcitationLimiterDynamicsBusinessDelegate.class.getName());
}
