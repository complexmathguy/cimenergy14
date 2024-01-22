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
 * Temperature business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of Temperature related services in the case of a Temperature
 *       business related service failing.
 *   <li>Exposes a simpler, uniform Temperature interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill Temperature business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class TemperatureBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public TemperatureBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * Temperature Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return TemperatureBusinessDelegate
   */
  public static TemperatureBusinessDelegate getTemperatureInstance() {
    return (new TemperatureBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createTemperature(CreateTemperatureCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getTemperatureId() == null) command.setTemperatureId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      TemperatureValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateTemperatureCommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateTemperatureCommand of Temperature is " + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create Temperature - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateTemperatureCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateTemperature(UpdateTemperatureCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      TemperatureValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateTemperatureCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save Temperature - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteTemperatureCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteTemperatureCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TemperatureValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteTemperatureCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to delete Temperature using Id = " + command.getTemperatureId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the Temperature via TemperatureFetchOneSummary
   *
   * @param summary TemperatureFetchOneSummary
   * @return TemperatureFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public Temperature getTemperature(TemperatureFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("TemperatureFetchOneSummary arg cannot be null");

    Temperature entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      TemperatureValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a Temperature
      // --------------------------------------
      CompletableFuture<Temperature> futureEntity =
          queryGateway.query(
              new FindTemperatureQuery(new LoadTemperatureFilter(summary.getTemperatureId())),
              ResponseTypes.instanceOf(Temperature.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate Temperature with id " + summary.getTemperatureId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all Temperatures
   *
   * @return List<Temperature>
   * @exception ProcessingException Thrown if any problems
   */
  public List<Temperature> getAllTemperature() throws ProcessingException {
    List<Temperature> list = null;

    try {
      CompletableFuture<List<Temperature>> futureList =
          queryGateway.query(
              new FindAllTemperatureQuery(), ResponseTypes.multipleInstancesOf(Temperature.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all Temperature";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Value on Temperature
   *
   * @param command AssignValueToTemperatureCommand
   * @exception ProcessingException
   */
  public void assignValue(AssignValueToTemperatureCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getTemperatureId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .FloatProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .FloatProxyBusinessDelegate.getFloatProxyInstance();
    TemperatureBusinessDelegate parentDelegate =
        TemperatureBusinessDelegate.getTemperatureInstance();
    UUID childId = command.getAssignment().getFloatProxyId();
    FloatProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      TemperatureValidator.getInstance().validate(command);

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
   * unAssign Value on Temperature
   *
   * @param command UnAssignValueFromTemperatureCommand
   * @exception ProcessingException
   */
  public void unAssignValue(UnAssignValueFromTemperatureCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TemperatureValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Value on Temperature";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return Temperature
   */
  private Temperature load(UUID id) throws ProcessingException {
    temperature =
        TemperatureBusinessDelegate.getTemperatureInstance()
            .getTemperature(new TemperatureFetchOneSummary(id));
    return temperature;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private Temperature temperature = null;
  private static final Logger LOGGER =
      Logger.getLogger(TemperatureBusinessDelegate.class.getName());
}
