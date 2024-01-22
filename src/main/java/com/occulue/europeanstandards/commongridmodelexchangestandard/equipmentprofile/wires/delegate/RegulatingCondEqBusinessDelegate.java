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
 * RegulatingCondEq business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of RegulatingCondEq related services in the case of a
 *       RegulatingCondEq business related service failing.
 *   <li>Exposes a simpler, uniform RegulatingCondEq interface to the business tier, making it easy
 *       for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill RegulatingCondEq business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class RegulatingCondEqBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public RegulatingCondEqBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * RegulatingCondEq Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return RegulatingCondEqBusinessDelegate
   */
  public static RegulatingCondEqBusinessDelegate getRegulatingCondEqInstance() {
    return (new RegulatingCondEqBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createRegulatingCondEq(CreateRegulatingCondEqCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getRegulatingCondEqId() == null) command.setRegulatingCondEqId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      RegulatingCondEqValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateRegulatingCondEqCommand - by convention the future return value for a
      // create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateRegulatingCondEqCommand of RegulatingCondEq is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create RegulatingCondEq - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateRegulatingCondEqCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateRegulatingCondEq(UpdateRegulatingCondEqCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      RegulatingCondEqValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateRegulatingCondEqCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save RegulatingCondEq - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteRegulatingCondEqCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteRegulatingCondEqCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      RegulatingCondEqValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteRegulatingCondEqCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete RegulatingCondEq using Id = " + command.getRegulatingCondEqId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the RegulatingCondEq via RegulatingCondEqFetchOneSummary
   *
   * @param summary RegulatingCondEqFetchOneSummary
   * @return RegulatingCondEqFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public RegulatingCondEq getRegulatingCondEq(RegulatingCondEqFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("RegulatingCondEqFetchOneSummary arg cannot be null");

    RegulatingCondEq entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      RegulatingCondEqValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a RegulatingCondEq
      // --------------------------------------
      CompletableFuture<RegulatingCondEq> futureEntity =
          queryGateway.query(
              new FindRegulatingCondEqQuery(
                  new LoadRegulatingCondEqFilter(summary.getRegulatingCondEqId())),
              ResponseTypes.instanceOf(RegulatingCondEq.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate RegulatingCondEq with id " + summary.getRegulatingCondEqId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all RegulatingCondEqs
   *
   * @return List<RegulatingCondEq>
   * @exception ProcessingException Thrown if any problems
   */
  public List<RegulatingCondEq> getAllRegulatingCondEq() throws ProcessingException {
    List<RegulatingCondEq> list = null;

    try {
      CompletableFuture<List<RegulatingCondEq>> futureList =
          queryGateway.query(
              new FindAllRegulatingCondEqQuery(),
              ResponseTypes.multipleInstancesOf(RegulatingCondEq.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all RegulatingCondEq";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * add RegulatingCondEq to RegulatingCondEq
   *
   * @param command AssignRegulatingCondEqToRegulatingCondEqCommand
   * @exception ProcessingException
   */
  public void addToRegulatingCondEq(AssignRegulatingCondEqToRegulatingCondEqCommand command)
      throws ProcessingException {

    // -------------------------------------------
    // load the parent
    // -------------------------------------------
    load(command.getRegulatingCondEqId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.delegate
            .RegulatingCondEqBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires
                .delegate.RegulatingCondEqBusinessDelegate.getRegulatingCondEqInstance();
    RegulatingCondEqBusinessDelegate parentDelegate =
        RegulatingCondEqBusinessDelegate.getRegulatingCondEqInstance();
    UUID childId = command.getAddTo().getRegulatingCondEqId();

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      RegulatingCondEqValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to add a RegulatingCondEq as RegulatingCondEq to RegulatingCondEq";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * remove RegulatingCondEq from RegulatingCondEq
   *
   * @param command RemoveRegulatingCondEqFromRegulatingCondEqCommand
   * @exception ProcessingException
   */
  public void removeFromRegulatingCondEq(RemoveRegulatingCondEqFromRegulatingCondEqCommand command)
      throws ProcessingException {

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.delegate
            .RegulatingCondEqBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires
                .delegate.RegulatingCondEqBusinessDelegate.getRegulatingCondEqInstance();
    UUID childId = command.getRemoveFrom().getRegulatingCondEqId();

    try {

      // --------------------------------------
      // validate the command
      // --------------------------------------
      RegulatingCondEqValidator.getInstance().validate(command);

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
   * @return RegulatingCondEq
   */
  private RegulatingCondEq load(UUID id) throws ProcessingException {
    regulatingCondEq =
        RegulatingCondEqBusinessDelegate.getRegulatingCondEqInstance()
            .getRegulatingCondEq(new RegulatingCondEqFetchOneSummary(id));
    return regulatingCondEq;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private RegulatingCondEq regulatingCondEq = null;
  private static final Logger LOGGER =
      Logger.getLogger(RegulatingCondEqBusinessDelegate.class.getName());
}
