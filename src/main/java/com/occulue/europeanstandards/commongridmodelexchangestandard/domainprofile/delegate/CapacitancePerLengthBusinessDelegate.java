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
 * CapacitancePerLength business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of CapacitancePerLength related services in the case of a
 *       CapacitancePerLength business related service failing.
 *   <li>Exposes a simpler, uniform CapacitancePerLength interface to the business tier, making it
 *       easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill CapacitancePerLength
 *       business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class CapacitancePerLengthBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public CapacitancePerLengthBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * CapacitancePerLength Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return CapacitancePerLengthBusinessDelegate
   */
  public static CapacitancePerLengthBusinessDelegate getCapacitancePerLengthInstance() {
    return (new CapacitancePerLengthBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createCapacitancePerLength(
      CreateCapacitancePerLengthCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getCapacitancePerLengthId() == null)
        command.setCapacitancePerLengthId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      CapacitancePerLengthValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateCapacitancePerLengthCommand - by convention the future return value for a
      // create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateCapacitancePerLengthCommand of CapacitancePerLength is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create CapacitancePerLength - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateCapacitancePerLengthCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateCapacitancePerLength(
      UpdateCapacitancePerLengthCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      CapacitancePerLengthValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateCapacitancePerLengthCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save CapacitancePerLength - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteCapacitancePerLengthCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteCapacitancePerLengthCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      CapacitancePerLengthValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteCapacitancePerLengthCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete CapacitancePerLength using Id = " + command.getCapacitancePerLengthId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the CapacitancePerLength via CapacitancePerLengthFetchOneSummary
   *
   * @param summary CapacitancePerLengthFetchOneSummary
   * @return CapacitancePerLengthFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public CapacitancePerLength getCapacitancePerLength(CapacitancePerLengthFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("CapacitancePerLengthFetchOneSummary arg cannot be null");

    CapacitancePerLength entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      CapacitancePerLengthValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a CapacitancePerLength
      // --------------------------------------
      CompletableFuture<CapacitancePerLength> futureEntity =
          queryGateway.query(
              new FindCapacitancePerLengthQuery(
                  new LoadCapacitancePerLengthFilter(summary.getCapacitancePerLengthId())),
              ResponseTypes.instanceOf(CapacitancePerLength.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate CapacitancePerLength with id " + summary.getCapacitancePerLengthId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all CapacitancePerLengths
   *
   * @return List<CapacitancePerLength>
   * @exception ProcessingException Thrown if any problems
   */
  public List<CapacitancePerLength> getAllCapacitancePerLength() throws ProcessingException {
    List<CapacitancePerLength> list = null;

    try {
      CompletableFuture<List<CapacitancePerLength>> futureList =
          queryGateway.query(
              new FindAllCapacitancePerLengthQuery(),
              ResponseTypes.multipleInstancesOf(CapacitancePerLength.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all CapacitancePerLength";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Value on CapacitancePerLength
   *
   * @param command AssignValueToCapacitancePerLengthCommand
   * @exception ProcessingException
   */
  public void assignValue(AssignValueToCapacitancePerLengthCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getCapacitancePerLengthId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .FloatProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .FloatProxyBusinessDelegate.getFloatProxyInstance();
    CapacitancePerLengthBusinessDelegate parentDelegate =
        CapacitancePerLengthBusinessDelegate.getCapacitancePerLengthInstance();
    UUID childId = command.getAssignment().getFloatProxyId();
    FloatProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      CapacitancePerLengthValidator.getInstance().validate(command);

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
   * unAssign Value on CapacitancePerLength
   *
   * @param command UnAssignValueFromCapacitancePerLengthCommand
   * @exception ProcessingException
   */
  public void unAssignValue(UnAssignValueFromCapacitancePerLengthCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      CapacitancePerLengthValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Value on CapacitancePerLength";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return CapacitancePerLength
   */
  private CapacitancePerLength load(UUID id) throws ProcessingException {
    capacitancePerLength =
        CapacitancePerLengthBusinessDelegate.getCapacitancePerLengthInstance()
            .getCapacitancePerLength(new CapacitancePerLengthFetchOneSummary(id));
    return capacitancePerLength;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private CapacitancePerLength capacitancePerLength = null;
  private static final Logger LOGGER =
      Logger.getLogger(CapacitancePerLengthBusinessDelegate.class.getName());
}
