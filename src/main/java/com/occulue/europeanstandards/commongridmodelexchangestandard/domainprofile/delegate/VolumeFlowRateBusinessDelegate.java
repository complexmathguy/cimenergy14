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
 * VolumeFlowRate business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of VolumeFlowRate related services in the case of a VolumeFlowRate
 *       business related service failing.
 *   <li>Exposes a simpler, uniform VolumeFlowRate interface to the business tier, making it easy
 *       for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill VolumeFlowRate business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class VolumeFlowRateBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public VolumeFlowRateBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * VolumeFlowRate Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return VolumeFlowRateBusinessDelegate
   */
  public static VolumeFlowRateBusinessDelegate getVolumeFlowRateInstance() {
    return (new VolumeFlowRateBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createVolumeFlowRate(CreateVolumeFlowRateCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getVolumeFlowRateId() == null) command.setVolumeFlowRateId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      VolumeFlowRateValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateVolumeFlowRateCommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateVolumeFlowRateCommand of VolumeFlowRate is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create VolumeFlowRate - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateVolumeFlowRateCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateVolumeFlowRate(UpdateVolumeFlowRateCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      VolumeFlowRateValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateVolumeFlowRateCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save VolumeFlowRate - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteVolumeFlowRateCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteVolumeFlowRateCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      VolumeFlowRateValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteVolumeFlowRateCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete VolumeFlowRate using Id = " + command.getVolumeFlowRateId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the VolumeFlowRate via VolumeFlowRateFetchOneSummary
   *
   * @param summary VolumeFlowRateFetchOneSummary
   * @return VolumeFlowRateFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public VolumeFlowRate getVolumeFlowRate(VolumeFlowRateFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("VolumeFlowRateFetchOneSummary arg cannot be null");

    VolumeFlowRate entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      VolumeFlowRateValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a VolumeFlowRate
      // --------------------------------------
      CompletableFuture<VolumeFlowRate> futureEntity =
          queryGateway.query(
              new FindVolumeFlowRateQuery(
                  new LoadVolumeFlowRateFilter(summary.getVolumeFlowRateId())),
              ResponseTypes.instanceOf(VolumeFlowRate.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate VolumeFlowRate with id " + summary.getVolumeFlowRateId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all VolumeFlowRates
   *
   * @return List<VolumeFlowRate>
   * @exception ProcessingException Thrown if any problems
   */
  public List<VolumeFlowRate> getAllVolumeFlowRate() throws ProcessingException {
    List<VolumeFlowRate> list = null;

    try {
      CompletableFuture<List<VolumeFlowRate>> futureList =
          queryGateway.query(
              new FindAllVolumeFlowRateQuery(),
              ResponseTypes.multipleInstancesOf(VolumeFlowRate.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all VolumeFlowRate";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Value on VolumeFlowRate
   *
   * @param command AssignValueToVolumeFlowRateCommand
   * @exception ProcessingException
   */
  public void assignValue(AssignValueToVolumeFlowRateCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getVolumeFlowRateId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .FloatProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .FloatProxyBusinessDelegate.getFloatProxyInstance();
    VolumeFlowRateBusinessDelegate parentDelegate =
        VolumeFlowRateBusinessDelegate.getVolumeFlowRateInstance();
    UUID childId = command.getAssignment().getFloatProxyId();
    FloatProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      VolumeFlowRateValidator.getInstance().validate(command);

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
   * unAssign Value on VolumeFlowRate
   *
   * @param command UnAssignValueFromVolumeFlowRateCommand
   * @exception ProcessingException
   */
  public void unAssignValue(UnAssignValueFromVolumeFlowRateCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      VolumeFlowRateValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Value on VolumeFlowRate";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return VolumeFlowRate
   */
  private VolumeFlowRate load(UUID id) throws ProcessingException {
    volumeFlowRate =
        VolumeFlowRateBusinessDelegate.getVolumeFlowRateInstance()
            .getVolumeFlowRate(new VolumeFlowRateFetchOneSummary(id));
    return volumeFlowRate;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private VolumeFlowRate volumeFlowRate = null;
  private static final Logger LOGGER =
      Logger.getLogger(VolumeFlowRateBusinessDelegate.class.getName());
}
