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
 * ACDCConverterDCTerminal business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of ACDCConverterDCTerminal related services in the case of a
 *       ACDCConverterDCTerminal business related service failing.
 *   <li>Exposes a simpler, uniform ACDCConverterDCTerminal interface to the business tier, making
 *       it easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill ACDCConverterDCTerminal
 *       business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class ACDCConverterDCTerminalBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public ACDCConverterDCTerminalBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * ACDCConverterDCTerminal Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return ACDCConverterDCTerminalBusinessDelegate
   */
  public static ACDCConverterDCTerminalBusinessDelegate getACDCConverterDCTerminalInstance() {
    return (new ACDCConverterDCTerminalBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createACDCConverterDCTerminal(
      CreateACDCConverterDCTerminalCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getACDCConverterDCTerminalId() == null)
        command.setACDCConverterDCTerminalId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      ACDCConverterDCTerminalValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateACDCConverterDCTerminalCommand - by convention the future return value for
      // a create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateACDCConverterDCTerminalCommand of ACDCConverterDCTerminal is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create ACDCConverterDCTerminal - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateACDCConverterDCTerminalCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateACDCConverterDCTerminal(
      UpdateACDCConverterDCTerminalCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      ACDCConverterDCTerminalValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateACDCConverterDCTerminalCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save ACDCConverterDCTerminal - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteACDCConverterDCTerminalCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteACDCConverterDCTerminalCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ACDCConverterDCTerminalValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteACDCConverterDCTerminalCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete ACDCConverterDCTerminal using Id = "
              + command.getACDCConverterDCTerminalId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the ACDCConverterDCTerminal via ACDCConverterDCTerminalFetchOneSummary
   *
   * @param summary ACDCConverterDCTerminalFetchOneSummary
   * @return ACDCConverterDCTerminalFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public ACDCConverterDCTerminal getACDCConverterDCTerminal(
      ACDCConverterDCTerminalFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException(
          "ACDCConverterDCTerminalFetchOneSummary arg cannot be null");

    ACDCConverterDCTerminal entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      ACDCConverterDCTerminalValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a ACDCConverterDCTerminal
      // --------------------------------------
      CompletableFuture<ACDCConverterDCTerminal> futureEntity =
          queryGateway.query(
              new FindACDCConverterDCTerminalQuery(
                  new LoadACDCConverterDCTerminalFilter(summary.getACDCConverterDCTerminalId())),
              ResponseTypes.instanceOf(ACDCConverterDCTerminal.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate ACDCConverterDCTerminal with id "
              + summary.getACDCConverterDCTerminalId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all ACDCConverterDCTerminals
   *
   * @return List<ACDCConverterDCTerminal>
   * @exception ProcessingException Thrown if any problems
   */
  public List<ACDCConverterDCTerminal> getAllACDCConverterDCTerminal() throws ProcessingException {
    List<ACDCConverterDCTerminal> list = null;

    try {
      CompletableFuture<List<ACDCConverterDCTerminal>> futureList =
          queryGateway.query(
              new FindAllACDCConverterDCTerminalQuery(),
              ResponseTypes.multipleInstancesOf(ACDCConverterDCTerminal.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all ACDCConverterDCTerminal";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * add ACDCConverterDCTerminal to DCTerminals
   *
   * @param command AssignDCTerminalsToACDCConverterDCTerminalCommand
   * @exception ProcessingException
   */
  public void addToDCTerminals(AssignDCTerminalsToACDCConverterDCTerminalCommand command)
      throws ProcessingException {

    // -------------------------------------------
    // load the parent
    // -------------------------------------------
    load(command.getACDCConverterDCTerminalId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.delegate
            .ACDCConverterDCTerminalBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc
                .delegate.ACDCConverterDCTerminalBusinessDelegate
                .getACDCConverterDCTerminalInstance();
    ACDCConverterDCTerminalBusinessDelegate parentDelegate =
        ACDCConverterDCTerminalBusinessDelegate.getACDCConverterDCTerminalInstance();
    UUID childId = command.getAddTo().getACDCConverterDCTerminalId();

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ACDCConverterDCTerminalValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg =
          "Failed to add a ACDCConverterDCTerminal as DCTerminals to ACDCConverterDCTerminal";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * remove ACDCConverterDCTerminal from DCTerminals
   *
   * @param command RemoveDCTerminalsFromACDCConverterDCTerminalCommand
   * @exception ProcessingException
   */
  public void removeFromDCTerminals(RemoveDCTerminalsFromACDCConverterDCTerminalCommand command)
      throws ProcessingException {

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.delegate
            .ACDCConverterDCTerminalBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc
                .delegate.ACDCConverterDCTerminalBusinessDelegate
                .getACDCConverterDCTerminalInstance();
    UUID childId = command.getRemoveFrom().getACDCConverterDCTerminalId();

    try {

      // --------------------------------------
      // validate the command
      // --------------------------------------
      ACDCConverterDCTerminalValidator.getInstance().validate(command);

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
   * @return ACDCConverterDCTerminal
   */
  private ACDCConverterDCTerminal load(UUID id) throws ProcessingException {
    aCDCConverterDCTerminal =
        ACDCConverterDCTerminalBusinessDelegate.getACDCConverterDCTerminalInstance()
            .getACDCConverterDCTerminal(new ACDCConverterDCTerminalFetchOneSummary(id));
    return aCDCConverterDCTerminal;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private ACDCConverterDCTerminal aCDCConverterDCTerminal = null;
  private static final Logger LOGGER =
      Logger.getLogger(ACDCConverterDCTerminalBusinessDelegate.class.getName());
}
