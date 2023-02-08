'use strict';

/**
 * fave-stock service
 */

const { createCoreService } = require('@strapi/strapi').factories;

module.exports = createCoreService('api::fave-stock.fave-stock');
