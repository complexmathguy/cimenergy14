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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.validator.*;
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
 * DCTerminal business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of DCTerminal related services in the case of a DCTerminal business
 *       related service failing.
 *   <li>Exposes a simpler, uniform DCTerminal interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill DCTerminal business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class DCTerminalBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public DCTerminalBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * DCTerminal Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return DCTerminalBusinessDelegate
   */
  public static DCTerminalBusinessDelegate getDCTerminalInstance() {
    return (new DCTerminalBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createDCTerminal(CreateDCTerminalCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getDCTerminalId() == null) command.setDCTerminalId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      DCTerminalValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateDCTerminalCommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateDCTerminalCommand of DCTerminal is " + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create DCTerminal - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateDCTerminalCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateDCTerminal(UpdateDCTerminalCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      DCTerminalValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateDCTerminalCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save DCTerminal - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteDCTerminalCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteDCTerminalCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DCTerminalValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteDCTerminalCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to delete DCTerminal using Id = " + command.getDCTerminalId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the DCTerminal via DCTerminalFetchOneSummary
   *
   * @param summary DCTerminalFetchOneSummary
   * @return DCTerminalFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public DCTerminal getDCTerminal(DCTerminalFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("DCTerminalFetchOneSummary arg cannot be null");

    DCTerminal entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      DCTerminalValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a DCTerminal
      // --------------------------------------
      CompletableFuture<DCTerminal> futureEntity =
          queryGateway.query(
              new FindDCTerminalQuery(new LoadDCTerminalFilter(summary.getDCTerminalId())),
              ResponseTypes.instanceOf(DCTerminal.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate DCTerminal with id " + summary.getDCTerminalId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all DCTerminals
   *
   * @return List<DCTerminal>
   * @exception ProcessingException Thrown if any problems
   */
  public List<DCTerminal> getAllDCTerminal() throws ProcessingException {
    List<DCTerminal> list = null;

    try {
      CompletableFuture<List<DCTerminal>> futureList =
          queryGateway.query(
              new FindAllDCTerminalQuery(), ResponseTypes.multipleInstancesOf(DCTerminal.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all DCTerminal";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * add DCTerminal to DCTerminals
   *
   * @param command AssignDCTerminalsToDCTerminalCommand
   * @exception ProcessingException
   */
  public void addToDCTerminals(AssignDCTerminalsToDCTerminalCommand command)
      throws ProcessingException {

    // -------------------------------------------
    // load the parent
    // -------------------------------------------
    load(command.getDCTerminalId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.delegate
            .DCTerminalBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc
                .delegate.DCTerminalBusinessDelegate.getDCTerminalInstance();
    DCTerminalBusinessDelegate parentDelegate = DCTerminalBusinessDelegate.getDCTerminalInstance();
    UUID childId = command.getAddTo().getDCTerminalId();

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DCTerminalValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to add a DCTerminal as DCTerminals to DCTerminal";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * remove DCTerminal from DCTerminals
   *
   * @param command RemoveDCTerminalsFromDCTerminalCommand
   * @exception ProcessingException
   */
  public void removeFromDCTerminals(RemoveDCTerminalsFromDCTerminalCommand command)
      throws ProcessingException {

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.delegate
            .DCTerminalBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc
                .delegate.DCTerminalBusinessDelegate.getDCTerminalInstance();
    UUID childId = command.getRemoveFrom().getDCTerminalId();

    try {

      // --------------------------------------
      // validate the command
      // --------------------------------------
      DCTerminalValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Exception exc) {
      final String msg = "Failed to remove child using Id " + childId;
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return DCTerminal
   */
  private DCTerminal load(UUID id) throws ProcessingException {
    dCTerminal =
        DCTerminalBusinessDelegate.getDCTerminalInstance()
            .getDCTerminal(new DCTerminalFetchOneSummary(id));
    return dCTerminal;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private DCTerminal dCTerminal = null;
  private static final Logger LOGGER = Logger.getLogger(DCTerminalBusinessDelegate.class.getName());
}
