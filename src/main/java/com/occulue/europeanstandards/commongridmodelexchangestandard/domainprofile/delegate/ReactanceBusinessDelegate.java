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
package com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.validator.*;
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
 * Reactance business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of Reactance related services in the case of a Reactance business
 *       related service failing.
 *   <li>Exposes a simpler, uniform Reactance interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill Reactance business related
 *       services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class ReactanceBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public ReactanceBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * Reactance Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return ReactanceBusinessDelegate
   */
  public static ReactanceBusinessDelegate getReactanceInstance() {
    return (new ReactanceBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createReactance(CreateReactanceCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getReactanceId() == null) command.setReactanceId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      ReactanceValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateReactanceCommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateReactanceCommand of Reactance is " + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create Reactance - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateReactanceCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateReactance(UpdateReactanceCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      ReactanceValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateReactanceCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save Reactance - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteReactanceCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteReactanceCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ReactanceValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteReactanceCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to delete Reactance using Id = " + command.getReactanceId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the Reactance via ReactanceFetchOneSummary
   *
   * @param summary ReactanceFetchOneSummary
   * @return ReactanceFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public Reactance getReactance(ReactanceFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("ReactanceFetchOneSummary arg cannot be null");

    Reactance entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      ReactanceValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a Reactance
      // --------------------------------------
      CompletableFuture<Reactance> futureEntity =
          queryGateway.query(
              new FindReactanceQuery(new LoadReactanceFilter(summary.getReactanceId())),
              ResponseTypes.instanceOf(Reactance.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate Reactance with id " + summary.getReactanceId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all Reactances
   *
   * @return List<Reactance>
   * @exception ProcessingException Thrown if any problems
   */
  public List<Reactance> getAllReactance() throws ProcessingException {
    List<Reactance> list = null;

    try {
      CompletableFuture<List<Reactance>> futureList =
          queryGateway.query(
              new FindAllReactanceQuery(), ResponseTypes.multipleInstancesOf(Reactance.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all Reactance";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Value on Reactance
   *
   * @param command AssignValueToReactanceCommand
   * @exception ProcessingException
   */
  public void assignValue(AssignValueToReactanceCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getReactanceId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .FloatProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .FloatProxyBusinessDelegate.getFloatProxyInstance();
    ReactanceBusinessDelegate parentDelegate = ReactanceBusinessDelegate.getReactanceInstance();
    UUID childId = command.getAssignment().getFloatProxyId();
    FloatProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ReactanceValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get FloatProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Value on Reactance
   *
   * @param command UnAssignValueFromReactanceCommand
   * @exception ProcessingException
   */
  public void unAssignValue(UnAssignValueFromReactanceCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ReactanceValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Value on Reactance";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return Reactance
   */
  private Reactance load(UUID id) throws ProcessingException {
    reactance =
        ReactanceBusinessDelegate.getReactanceInstance()
            .getReactance(new ReactanceFetchOneSummary(id));
    return reactance;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private Reactance reactance = null;
  private static final Logger LOGGER = Logger.getLogger(ReactanceBusinessDelegate.class.getName());
}
