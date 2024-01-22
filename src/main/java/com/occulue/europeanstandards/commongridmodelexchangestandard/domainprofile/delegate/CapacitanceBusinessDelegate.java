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
 * Capacitance business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of Capacitance related services in the case of a Capacitance
 *       business related service failing.
 *   <li>Exposes a simpler, uniform Capacitance interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill Capacitance business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class CapacitanceBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public CapacitanceBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * Capacitance Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return CapacitanceBusinessDelegate
   */
  public static CapacitanceBusinessDelegate getCapacitanceInstance() {
    return (new CapacitanceBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createCapacitance(CreateCapacitanceCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getCapacitanceId() == null) command.setCapacitanceId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      CapacitanceValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateCapacitanceCommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateCapacitanceCommand of Capacitance is " + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create Capacitance - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateCapacitanceCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateCapacitance(UpdateCapacitanceCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      CapacitanceValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateCapacitanceCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save Capacitance - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteCapacitanceCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteCapacitanceCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      CapacitanceValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteCapacitanceCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to delete Capacitance using Id = " + command.getCapacitanceId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the Capacitance via CapacitanceFetchOneSummary
   *
   * @param summary CapacitanceFetchOneSummary
   * @return CapacitanceFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public Capacitance getCapacitance(CapacitanceFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("CapacitanceFetchOneSummary arg cannot be null");

    Capacitance entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      CapacitanceValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a Capacitance
      // --------------------------------------
      CompletableFuture<Capacitance> futureEntity =
          queryGateway.query(
              new FindCapacitanceQuery(new LoadCapacitanceFilter(summary.getCapacitanceId())),
              ResponseTypes.instanceOf(Capacitance.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate Capacitance with id " + summary.getCapacitanceId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all Capacitances
   *
   * @return List<Capacitance>
   * @exception ProcessingException Thrown if any problems
   */
  public List<Capacitance> getAllCapacitance() throws ProcessingException {
    List<Capacitance> list = null;

    try {
      CompletableFuture<List<Capacitance>> futureList =
          queryGateway.query(
              new FindAllCapacitanceQuery(), ResponseTypes.multipleInstancesOf(Capacitance.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all Capacitance";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Value on Capacitance
   *
   * @param command AssignValueToCapacitanceCommand
   * @exception ProcessingException
   */
  public void assignValue(AssignValueToCapacitanceCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getCapacitanceId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .FloatProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .FloatProxyBusinessDelegate.getFloatProxyInstance();
    CapacitanceBusinessDelegate parentDelegate =
        CapacitanceBusinessDelegate.getCapacitanceInstance();
    UUID childId = command.getAssignment().getFloatProxyId();
    FloatProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      CapacitanceValidator.getInstance().validate(command);

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
   * unAssign Value on Capacitance
   *
   * @param command UnAssignValueFromCapacitanceCommand
   * @exception ProcessingException
   */
  public void unAssignValue(UnAssignValueFromCapacitanceCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      CapacitanceValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Value on Capacitance";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return Capacitance
   */
  private Capacitance load(UUID id) throws ProcessingException {
    capacitance =
        CapacitanceBusinessDelegate.getCapacitanceInstance()
            .getCapacitance(new CapacitanceFetchOneSummary(id));
    return capacitance;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private Capacitance capacitance = null;
  private static final Logger LOGGER =
      Logger.getLogger(CapacitanceBusinessDelegate.class.getName());
}
