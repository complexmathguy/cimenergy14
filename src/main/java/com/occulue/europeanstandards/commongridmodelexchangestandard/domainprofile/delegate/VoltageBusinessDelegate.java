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
 * Voltage business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of Voltage related services in the case of a Voltage business
 *       related service failing.
 *   <li>Exposes a simpler, uniform Voltage interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill Voltage business related
 *       services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class VoltageBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public VoltageBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * Voltage Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return VoltageBusinessDelegate
   */
  public static VoltageBusinessDelegate getVoltageInstance() {
    return (new VoltageBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createVoltage(CreateVoltageCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getVoltageId() == null) command.setVoltageId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      VoltageValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateVoltageCommand - by convention the future return value for a create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateVoltageCommand of Voltage is " + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create Voltage - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateVoltageCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateVoltage(UpdateVoltageCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      VoltageValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateVoltageCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save Voltage - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteVoltageCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteVoltageCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      VoltageValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteVoltageCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to delete Voltage using Id = " + command.getVoltageId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the Voltage via VoltageFetchOneSummary
   *
   * @param summary VoltageFetchOneSummary
   * @return VoltageFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public Voltage getVoltage(VoltageFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("VoltageFetchOneSummary arg cannot be null");

    Voltage entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      VoltageValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a Voltage
      // --------------------------------------
      CompletableFuture<Voltage> futureEntity =
          queryGateway.query(
              new FindVoltageQuery(new LoadVoltageFilter(summary.getVoltageId())),
              ResponseTypes.instanceOf(Voltage.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate Voltage with id " + summary.getVoltageId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all Voltages
   *
   * @return List<Voltage>
   * @exception ProcessingException Thrown if any problems
   */
  public List<Voltage> getAllVoltage() throws ProcessingException {
    List<Voltage> list = null;

    try {
      CompletableFuture<List<Voltage>> futureList =
          queryGateway.query(
              new FindAllVoltageQuery(), ResponseTypes.multipleInstancesOf(Voltage.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all Voltage";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Value on Voltage
   *
   * @param command AssignValueToVoltageCommand
   * @exception ProcessingException
   */
  public void assignValue(AssignValueToVoltageCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getVoltageId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .FloatProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .FloatProxyBusinessDelegate.getFloatProxyInstance();
    VoltageBusinessDelegate parentDelegate = VoltageBusinessDelegate.getVoltageInstance();
    UUID childId = command.getAssignment().getFloatProxyId();
    FloatProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      VoltageValidator.getInstance().validate(command);

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
   * unAssign Value on Voltage
   *
   * @param command UnAssignValueFromVoltageCommand
   * @exception ProcessingException
   */
  public void unAssignValue(UnAssignValueFromVoltageCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      VoltageValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Value on Voltage";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return Voltage
   */
  private Voltage load(UUID id) throws ProcessingException {
    voltage =
        VoltageBusinessDelegate.getVoltageInstance().getVoltage(new VoltageFetchOneSummary(id));
    return voltage;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private Voltage voltage = null;
  private static final Logger LOGGER = Logger.getLogger(VoltageBusinessDelegate.class.getName());
}
