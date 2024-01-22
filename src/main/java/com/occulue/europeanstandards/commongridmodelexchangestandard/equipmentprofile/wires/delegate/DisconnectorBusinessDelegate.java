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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.validator.*;
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
 * Disconnector business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of Disconnector related services in the case of a Disconnector
 *       business related service failing.
 *   <li>Exposes a simpler, uniform Disconnector interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill Disconnector business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class DisconnectorBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public DisconnectorBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * Disconnector Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return DisconnectorBusinessDelegate
   */
  public static DisconnectorBusinessDelegate getDisconnectorInstance() {
    return (new DisconnectorBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createDisconnector(CreateDisconnectorCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getDisconnectorId() == null) command.setDisconnectorId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      DisconnectorValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateDisconnectorCommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateDisconnectorCommand of Disconnector is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create Disconnector - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateDisconnectorCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateDisconnector(UpdateDisconnectorCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      DisconnectorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateDisconnectorCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save Disconnector - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteDisconnectorCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteDisconnectorCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DisconnectorValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteDisconnectorCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete Disconnector using Id = " + command.getDisconnectorId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the Disconnector via DisconnectorFetchOneSummary
   *
   * @param summary DisconnectorFetchOneSummary
   * @return DisconnectorFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public Disconnector getDisconnector(DisconnectorFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("DisconnectorFetchOneSummary arg cannot be null");

    Disconnector entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      DisconnectorValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a Disconnector
      // --------------------------------------
      CompletableFuture<Disconnector> futureEntity =
          queryGateway.query(
              new FindDisconnectorQuery(new LoadDisconnectorFilter(summary.getDisconnectorId())),
              ResponseTypes.instanceOf(Disconnector.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate Disconnector with id " + summary.getDisconnectorId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all Disconnectors
   *
   * @return List<Disconnector>
   * @exception ProcessingException Thrown if any problems
   */
  public List<Disconnector> getAllDisconnector() throws ProcessingException {
    List<Disconnector> list = null;

    try {
      CompletableFuture<List<Disconnector>> futureList =
          queryGateway.query(
              new FindAllDisconnectorQuery(),
              ResponseTypes.multipleInstancesOf(Disconnector.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all Disconnector";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return Disconnector
   */
  private Disconnector load(UUID id) throws ProcessingException {
    disconnector =
        DisconnectorBusinessDelegate.getDisconnectorInstance()
            .getDisconnector(new DisconnectorFetchOneSummary(id));
    return disconnector;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private Disconnector disconnector = null;
  private static final Logger LOGGER =
      Logger.getLogger(DisconnectorBusinessDelegate.class.getName());
}
